package org.lafeuille.adventofcode.y2019

sealed trait Move {
  def apply(position: Position): Position
}

object Move {

  object Up extends Move {
    override def apply(position: Position): Position =
      position.copy(y = position.y + 1)
  }

  object Down extends Move {
    override def apply(position: Position): Position =
      position.copy(y = position.y - 1)
  }

  object Right extends Move {
    override def apply(position: Position): Position =
      position.copy(x = position.x + 1)
  }

  object Left extends Move {
    override def apply(position: Position): Position =
      position.copy(x = position.x - 1)
  }

}
