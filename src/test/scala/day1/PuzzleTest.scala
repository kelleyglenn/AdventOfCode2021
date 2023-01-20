package day1

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class PuzzleTest extends AnyFlatSpec {
  private val exampleInput = Seq(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
  behavior of "Puzzle"

  it should "solve the first example problem" in {
    assert(Puzzle.numberOfIncreases(exampleInput) == 7)
  }
  it should "solve the first puzzle" in new SetupPuzzleInput {
    assert(Puzzle.numberOfIncreases(input) == 1390)
  }
  it should "calculate sums of sliding windows" in {
    assert(Puzzle.slidingWindowSums(exampleInput, 3) ==
      Seq(607, 618, 618, 617, 647, 716, 769, 792))
  }
  it should "solve the second example problem" in {
    assert(Puzzle.numberOfIncreases(Puzzle.slidingWindowSums(exampleInput, 3)) == 5)
  }
  it should "solve the second puzzle" in new SetupPuzzleInput {
    assert(Puzzle.numberOfIncreases(Puzzle.slidingWindowSums(input, 3)) == 1457)
  }

  class SetupPuzzleInput {
    val bufferedSource: BufferedSource =
      Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val input: Seq[Int] = bufferedSource.getLines.toSeq.map(_.toInt)
  }
}
