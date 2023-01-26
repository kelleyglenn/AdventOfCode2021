package day2

object Puzzle {

  def pilot(movements: Seq[(String, Int)]): (Int, Int) = {
    movements.foldLeft((0, 0)) {
      case ((horizontal, depth), (direction, amount)) => direction match {
        case "forward" => (horizontal + amount, depth)
        case "down" => (horizontal, depth + amount)
        case "up" => (horizontal, depth - amount)
      }
    }
  }

  def pilotAndAim(movements: Seq[(String, Int)]): (Int, Int, Int) = {
    movements.foldLeft((0, 0, 0)) {
      case ((horizontal, depth, aim), (direction, amount)) => direction match {
        case "forward" => (horizontal + amount, depth + (aim * amount), aim)
        case "down" => (horizontal, depth, aim + amount)
        case "up" => (horizontal, depth, aim - amount)
      }
    }
  }

}
