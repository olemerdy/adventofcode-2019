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
}

