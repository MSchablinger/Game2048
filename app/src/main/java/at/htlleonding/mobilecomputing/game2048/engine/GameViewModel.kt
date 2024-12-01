package at.htlleonding.mobilecomputing.game2048.engine

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import at.htlleonding.mobilecomputing.game2048.ui.utils.MovementDirection
import at.htlleonding.mobilecomputing.game2048.ui.utils.MovementDirection.*
class GameViewModel : ViewModel() {
    var state by mutableStateOf(GameState())
    val engine = Engine()

    fun move(direction: MovementDirection) {
        when (direction) {
            UP -> engine.moveTop()
            DOWN -> engine.moveBottom()
            LEFT -> engine.moveLeft()
            RIGHT -> engine.moveRight()
            NONE -> println()
        }
        engine.board.forEach {
            println(it)
        }

        println(state.toStringBaseClass())
        // Update the state with the new board after the move
        state = state.copy(board = engine.board)
        println(state.toStringBaseClass())
    }

    fun resetGame() {
        engine.init()
        state = state.copy(board = engine.board)
    }
}