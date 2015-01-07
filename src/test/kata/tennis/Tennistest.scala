package kata.tennis

import org.scalatest.{Matchers, FlatSpec}

class Tennistest extends FlatSpec with Matchers{
  "Scores" should "return score names" in {
    val game = new Game()
    game.scores(1,0) shouldBe "Fifteen,Love"
    game.scores(2,0) shouldBe "Thirty,Love"
    game.scores(3,0) shouldBe "Forty,Love"
    game.scores(0,1) shouldBe "Love,Fifteen"
  }

  it should "return winner name" in {
    val game = new Game()
    game.scores(4,2) shouldBe "Player 1 wins"
  }
}
