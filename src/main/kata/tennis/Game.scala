package kata.tennis

class Game {
  def scores(point1: Int, point2: Int) = {
    val name1 = scoreName(point1)
    val name2 = scoreName(point2)
    s"$name1,$name2"
  }

  def scoreName(point1: Int): String = {
    if (point1 == 2) "Thirty"
    else if (point1 == 3) "Forty"
    else if (point1 == 1) "Fifteen"
    else "Love"
  }
}
