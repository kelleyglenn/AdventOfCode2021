package day1

object Puzzle {
  def numberOfIncreases(depths: Seq[Int]): Int = {
    if (depths.length < 2) 0 else {
      (if (depths.head < depths(1)) 1 else 0) + numberOfIncreases(depths.tail)
    }
  }

  def slidingWindowSums(depths: Seq[Int], windowSize: Int): Seq[Int]={
    depths.sliding(windowSize).map(_.sum).toSeq
  }
}
