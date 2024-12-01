package at.htlleonding.mobilecomputing.game2048

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import at.htlleonding.mobilecomputing.game2048.engine.GameViewModel
import at.htlleonding.mobilecomputing.game2048.ui.Board
import at.htlleonding.mobilecomputing.game2048.ui.theme.Game2048Theme
import at.htlleonding.mobilecomputing.game2048.ui.theme.GameBackground
import at.htlleonding.mobilecomputing.game2048.ui.utils.MovementDirection.*;
import at.htlleonding.mobilecomputing.game2048.ui.utils.DragGesturesDirectionDetector

class MainActivity : ComponentActivity() {
    private val viewModel = viewModels<GameViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.value.resetGame()
        enableEdgeToEdge()
        setContent {
            Game2048Theme {
                var currentDirection by remember { mutableStateOf(NONE) }

                DragGesturesDirectionDetector(
                    modifier = Modifier.fillMaxSize().background(GameBackground),
                    onDirectionDetected = {
                        currentDirection = it
                        viewModel.value.move(currentDirection)
                    }
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Board(
                            viewModel = viewModel.value,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}
