package day3

object Puzzle {
  def gammaAndEpsilonRates(diagnostic: Seq[String]): (Int, Int) = {
    val bits: Seq[Seq[Int]] = diagnostic.map(_.toCharArray.map(_.asDigit))
    val sums: Seq[Int] =
      bits.foldLeft(Seq.fill(bits.head.size)(0)) { case (sum, cur) => sum.zip(cur).map(x => x._1 + x._2) }
    val gammaBits: String = sums.map {
      case s if s > diagnostic.length - s => '1'
      case _ => '0'
    }.mkString
    val epsilonBits: String = gammaBits.map {
      case '1' => '0'
      case _ => '1'
    }
    (Integer.parseUnsignedInt(gammaBits, 2), Integer.parseUnsignedInt(epsilonBits, 2))
  }

}
