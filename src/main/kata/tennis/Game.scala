package kata.tennis

class Game {
  val names = List("Love", "Fifteen", "Thirty", "Forty").toArray
  def scores(point1: Int, point2: Int) = {
    val name1 = names(point1)
    val name2 = names(point2)
    s"$name1,$name2"
  }

  def scoreName(point1: Int): String = {
    names(point1)
  }
}
