package org.lafeuille.adventofcode.y2019

case class Position(x: Int = 0, y: Int = 0) {
  def distance(that: Position = Position()): Int =
    Math.abs(x - that.x) + Math.abs(y - that.y)
}
