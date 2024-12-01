package at.htlleonding.mobilecomputing.game2048.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htlleonding.mobilecomputing.game2048.engine.GameViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Board(viewModel: GameViewModel, modifier: Modifier = Modifier) {
    val state = viewModel.state
    Column {
        state.board.forEach{ row ->
            Row(modifier = Modifier.width(200.dp)) {
                row.forEach { cell ->
                    Cell (
                        symbol = "" + cell,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    )
                }
            }
        }
    }
}