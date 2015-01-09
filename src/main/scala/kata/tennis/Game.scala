package kata.tennis

class Game(player1: String, player2: String) {
  def scores(point1: Int, point2: Int) = {
    (point1, point2) match {
      case Draw(Deuce()) => "Deuce"
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

  object Draw {
    def unapply(points:(Int, Int)): Option[(Int, Int)] = {
      if (points._1 == points._2) new Some(points)
      else None
    }
  }

  object Deuce {
    def unapply(points:(Int, Int)): Boolean = points._1>=3 && points._2>=3
  }

}
