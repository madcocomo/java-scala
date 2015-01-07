package kata.tennis

import org.scalatest.{Matchers, FlatSpec}

class Tennistest extends FlatSpec with Matchers{
  "Scores" should "return score names" in {
    val game = new Game()
    game.scores(1,0) shouldBe "Fifteen,Love"
    game.scores(2,0) shouldBe "Thirty,Love"
  }
}
