package kata.tennis

class Game(player1: String, player2: String) {
  val names = List("Love", "Fifteen", "Thirty", "Forty").toArray
  def scores(point1: Int, point2: Int) = {
    if (point1 < 4) {
      val name1 = names(point1)
      val name2 = names(point2)
      s"$name1,$name2"
    } else {
      s"$player1 wins"
    }

  }

  def scoreName(point1: Int): String = {
    names(point1)
  }
}
