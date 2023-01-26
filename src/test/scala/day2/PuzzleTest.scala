package day2

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class PuzzleTest extends AnyFlatSpec {
  private val exampleInput: Seq[(String, Int)] =
    Seq(("forward", 5), ("down", 5), ("forward", 8), ("up", 3), ("down", 8), ("forward", 2))
  behavior of "Puzzle"
  it should "solve the first example problem" in {
    assert(Puzzle.pilot(exampleInput) == (15, 10))
  }
  it should "solve the first puzzle" in new SetupPuzzleInput {
    assert(Puzzle.pilot(input) == (1923, 1001))
  }
  it should "solve the second example problem" in {
    assert(Puzzle.pilotAndAim(exampleInput) == (15, 60, 10))
  }
  it should "solve the second puzzle" in new SetupPuzzleInput {
    assert(Puzzle.pilotAndAim(input) == (1923, 1030939, 1001))
  }

  class SetupPuzzleInput {
    val bufferedSource: BufferedSource =
      Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val input: Seq[(String, Int)] = bufferedSource.getLines.toSeq.map(_.split(' ')).map(x => (x(0), x(1).toInt))
  }

}
