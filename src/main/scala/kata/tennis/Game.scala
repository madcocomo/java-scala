package kata.tennis

class Game(player1: String, player2: String) {
  def scores(point1: Int, point2: Int) = {
    (point1, point2) match {
      case Deuce(_) => "Deuce"
      case Draw(Score(name1), _) => s"$name1 all"
      case (Score(name1), Score(name2)) => s"$name1,$name2"
      case Win(Advantage(player)) => s"$player wins"
      case Advantage(player) => s"Advantage $player"
      case _ =>
    }
  }

  object Score {
    def unapply(point: Int): Option[String] =
      Array("Love", "Fifteen", "Thirty", "Forty").lift(point)
  }

  object Advantage {
    def unapply(points:(Int, Int)): Option[String] = {
      import points._
      new Some(
        if (_1 > _2) player1 else player2
      )
    }
  }

  object Win {
    def unapply(points:(Int, Int)): Option[(Int,Int)] = {
      import points._
      if ((_1-_2).abs > 1) new Some(points) else None
    }
  }

  case class pfExtractor(pf: PartialFunction[(Int, Int), (Int,Int)]) {
    def unapply(points:(Int, Int)): Option[(Int, Int)] = pf.lift(points)
  }

  class DrawPf extends PartialFunction[(Int, Int), (Int, Int)] {
    override def isDefinedAt(x: (Int, Int)): Boolean = x._1 == x._2
    override def apply(v1: (Int, Int)): (Int, Int) = v1
  }

  object Draw extends pfExtractor (new DrawPf)

  object Deuce extends pfExtractor (
    new DrawPf() {
      override def isDefinedAt(x: (Int, Int)) = x._1 >= 3 && super.isDefinedAt(x)
    }
  )

}
