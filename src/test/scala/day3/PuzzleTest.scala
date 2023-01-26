package day3

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class PuzzleTest extends AnyFlatSpec {
  private val exampleInput: Seq[String] = Seq(
    "00100",
    "11110",
    "10110",
    "10111",
    "10101",
    "01111",
    "00111",
    "11100",
    "10000",
    "11001",
    "00010",
    "01010")
  behavior of "Puzzle"
  it should "solve the first example problem" in {
    assert(Puzzle.gammaAndEpsilonRates(exampleInput) == (22, 9))
  }
  it should "solve the first puzzle" in new SetupPuzzleInput {
    assert(Puzzle.gammaAndEpsilonRates(input) == (2663, 1432))
  }

  class SetupPuzzleInput {
    val bufferedSource: BufferedSource =
      Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val input: Seq[String] = bufferedSource.getLines.toSeq
  }

}
