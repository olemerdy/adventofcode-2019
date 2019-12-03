package org.lafeuille.adventofcode.y2019.d03

import org.lafeuille.adventofcode.y2019.{Move, Position}

import scala.io.Source
import scala.io.Source.fromURL
import scala.util.matching.Regex

object Day03 {

  private val regex: Regex = "([UDRL])(\\d+)".r

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def moves(line: String): List[Move] =
    line.split(',').toList.flatMap {
      case regex(moveCode, times) =>
        val move = moveCode match {
          case "U" => Move.Up
          case "D" => Move.Down
          case "R" => Move.Right
          case "L" => Move.Left
        }
        List.fill(times.toInt)(move)
      case _ => throw new IllegalArgumentException
    }

  def myInputMoves: (List[Move], List[Move]) =
    myInput.getLines.map(moves).toList match {
      case a :: b :: Nil => (a, b)
      case _ => throw new IllegalArgumentException
    }

}

object Day03Part1 extends App {
  def allPositions(moves: List[Move], position: Position = Position()) = {
    @scala.annotation.tailrec
    def rec(moves: List[Move], current: Position, positions: Set[Position]): Set[Position] = moves match {
      case Nil => positions + current - position
      case move :: tail => rec(tail, move.apply(current), positions + current)
    }

    rec(moves, position, Set.empty)
  }

  def closestIntersectDistance(moves: (List[Move], List[Move])) = {
    val intersections = allPositions(moves._1).intersect(allPositions(moves._2))
    intersections.map(_.distance()).min
  }

  println(closestIntersectDistance(Day03.myInputMoves))

}
