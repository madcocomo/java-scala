package kata.tennis

class Game {
  def scores(point1: Int, point2: Int) = {
    val name1 = if (point1 == 2) "Thirty"
    else if (point1 == 3) "Forty"
    else if (point1 == 1) "Fifteen"
    else "Love"
    val name2 = if (point2 == 2) "Thirty"
    else if (point2 == 3) "Forty"
    else if (point2 == 1) "Fifteen"
    else "Love"
    s"$name1,$name2"
  }

}
