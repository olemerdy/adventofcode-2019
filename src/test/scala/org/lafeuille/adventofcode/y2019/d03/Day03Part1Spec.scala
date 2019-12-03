package org.lafeuille.adventofcode.y2019.d03

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day03Part1Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "My input" should {

    val table = Table(
      ("Moves 1", "Moves 2", "Distance"),
      ("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", 159),
      ("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 135)
    )

    forAll(table) { (moves1, moves2, distance) =>
      s"compute moves '$moves1' and '$moves2' to distance $distance" in {
        Day03Part1.closestIntersectDistance((Day03.moves(moves1), Day03.moves(moves2))) shouldBe distance
      }
    }
  }

}
