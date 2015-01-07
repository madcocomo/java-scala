package kata.tennis

class Game {
  def scores(point1: Int, point2: Int) = {
    val name1 = if (point1 == 2) "Thirty"
    else if (point1 == 3) "Forty"
    else "Fifteen"
    s"$name1,Love"
  }

}
