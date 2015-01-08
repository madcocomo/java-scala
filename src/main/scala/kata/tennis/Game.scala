package kata.tennis

class Game(player1: String, player2: String) {
  def scores(point1: Int, point2: Int) = {
    (point1, point2) match {
      case (Score(name1), Score(name2)) => s"$name1,$name2"
      case _ =>
          val winner = if (point1 > point2) {
            player1
          } else {
            player2
          }
          s"$winner wins"
    }
  }

  object Score {
    def unapply(point: Int): Option[String] =
      Array("Love", "Fifteen", "Thirty", "Forty").lift(point)
  }
}
