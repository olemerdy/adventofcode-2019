package org.lafeuille.adventofcode.y2019.d01

import scala.io.Source
import scala.io.Source.fromURL

object Day01 {

  def numbers: List[Int] =
    myInput.getLines.map(_.toInt).toList

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))
}

object Day01Part1 extends App {

  def computeFuel(mass: Int): Int =
    Math.max(0, mass / 3 - 2)

  def computeFuel(masses: List[Int]): Int =
    masses.map(computeFuel).sum

  println(computeFuel(Day01.numbers))

}

object Day01Part2 extends App {

  def computeFuel(mass: Int): Int = {
    Day01Part1.computeFuel(mass) match {
      case 0 => 0
      case n => n + computeFuel(n)
    }
  }

  def computeFuel(masses: List[Int]): Int =
    masses.map(computeFuel).sum

}

