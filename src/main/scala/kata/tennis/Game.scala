package kata.tennis

class Game(player1: String, player2: String) {
  def scores(point1: Int, point2: Int) = {
    (point1, point2) match {
      case Deuce(_) => "Deuce"
      case Draw(Score(name1), _) => s"$name1 all"
      case (Score(name1), Score(name2)) => s"$name1,$name2"
      case Win(player) => s"$player wins"
      case Advantage(player) => s"Advantage $player"
      case _ =>
    }
  }

  object Score {
    def unapply(point: Int): Option[String] =
      Array("Love", "Fifteen", "Thirty", "Forty").lift(point)
  }

  case class PFExtractor[T](pf: PartialFunction[(Int, Int), T]) {
    def unapply(points:(Int, Int)): Option[T] = pf.lift(points)
  }

  class DrawPf extends PartialFunction[(Int, Int), (Int, Int)] {
    override def isDefinedAt(x: (Int, Int)): Boolean = x._1 == x._2
    override def apply(v1: (Int, Int)): (Int, Int) = v1
  }
  object Draw extends PFExtractor(new DrawPf)

  class DeucePf extends DrawPf {
      override def isDefinedAt(x: (Int, Int)) = x._1 >= 3 && super.isDefinedAt(x)
  }
  object Deuce extends PFExtractor (new DeucePf)

  class AdvantagePf extends PartialFunction[(Int,Int), String] {
    override def isDefinedAt(x: (Int, Int)): Boolean = x._1 != x._2
    override def apply(v1: (Int, Int)): String = if (v1._1 > v1._2) player1 else player2
  }
  object Advantage extends PFExtractor (new AdvantagePf)

  class WinPf extends AdvantagePf{
    override def isDefinedAt(x: (Int, Int)): Boolean = (x._1-x._2).abs > 1
  }
  object Win extends PFExtractor (new WinPf)

}
