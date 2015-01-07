package kata.tennis

class Game(player1: String, player2: String) {
  val scoreNames = List("Love", "Fifteen", "Thirty", "Forty").toArray
  def scores(point1: Int, point2: Int) = {
    if (point1 < 4 && point2 < 4) {
      s"${scoreNames(point1)},${scoreNames(point2)}"
    } else {
      val winner = if (point1 > point2) {
        player1
      } else {
        player2
      }
      s"$winner wins"
    }
  }
}
