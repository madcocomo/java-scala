package kata.tennis

import org.scalatest.{Matchers, FlatSpec}

class Tennistest extends FlatSpec with Matchers{
  val game = new Game("Federer", "Nadal")
  "Scores" should "return score names" in {
    game.scores(1,0) shouldBe "Fifteen,Love"
    game.scores(2,0) shouldBe "Thirty,Love"
    game.scores(3,0) shouldBe "Forty,Love"
    game.scores(0,1) shouldBe "Love,Fifteen"
  }

  it should "return winner name" in {
    game.scores(4,2) shouldBe "Federer wins"
    game.scores(0,4) shouldBe "Nadal wins"
  }

  it should "return name all" in {
    game.scores(0,0) shouldBe "Love all"
  }

  it should "return Deuce" in {
    game.scores(3,3) shouldBe "Deuce"
    game.scores(4,4) shouldBe "Deuce"
  }
}
