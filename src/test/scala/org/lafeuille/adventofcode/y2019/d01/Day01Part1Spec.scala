package org.lafeuille.adventofcode.y2019.d01

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day01Part1Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("Mass", "Fuel"),
      (12, 2),
      (14, 2),
      (1969, 654),
      (100756, 33583)
    )

    forAll(table) { (mass, fuel) =>
      s"mass $mass" in {
        Day01Part1.computeFuel(mass) shouldBe fuel
      }
    }
  }

  "My input" should {
    val expected = 3125750
    s"reach $expected" in {
      Day01Part1.computeFuel(Day01.numbers) shouldBe expected
    }
  }
}
