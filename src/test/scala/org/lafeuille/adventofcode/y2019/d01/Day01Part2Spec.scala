package org.lafeuille.adventofcode.y2019.d01

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day01Part2Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("Mass", "Fuel"),
      (14, 2),
      (1969, 966),
      (100756, 50346)
    )

    forAll(table) { (mass, fuel) =>
      s"mass $mass" in {
        Day01Part2.computeFuel(mass) shouldBe fuel
      }
    }
  }

  "My input" should {
    val expected = 4685788
    s"reach $expected" in {
      Day01Part2.computeFuel(Day01.numbers) shouldBe expected
    }
  }

}
