package org.lafeuille.adventofcode.y2019.d03

import org.lafeuille.adventofcode.y2019.Move.{Down, Left, Right, Up}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day03Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "Move input" should {
    val table = Table(
      ("Line", "Moves"),
      ("U1,R1,D1,L1", Up :: Right :: Down :: Left :: Nil),
      ("U3,L2", Up :: Up :: Up :: Left :: Left :: Nil)
    )

    forAll(table) { (line, moves) =>
      s"resolve line '$line' into moves $moves" in {
        Day03.moves(line) shouldBe moves
      }
    }
  }

}
