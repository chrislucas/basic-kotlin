// Objects/ObjectEx3.kt
package objectsExercise3
import atomictest.*

interface AdventureGame {
  interface Environment
  interface Character
  val environment: Environment
  val characters: MutableList<Character>
  fun populate()
}

// TODO