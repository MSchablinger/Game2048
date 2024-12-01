package at.htlleonding.mobilecomputing.game2048.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.htlleonding.mobilecomputing.game2048.ui.theme.*

@ExperimentalComposeUiApi
@Composable
fun Cell(
    symbol: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    var bgColor: Color = GameCellBackground;
    var color: Color = Color.Gray;
    when (symbol) {
        "2" -> {
            bgColor = Game2Background
            color = Game2Color
        }
        "4" -> {
            bgColor = Game4Background
            color = Game4Color
        }
        "8" -> {
            bgColor = Game8Background
            color = Game8Color
        }
        "16" -> {
            bgColor = Game16Background
            color = Game8Color
        }
        "32" -> {
            bgColor = Game32Background
            color = Game8Color
        }
        "64" -> {
            bgColor = Game64Background
            color = Game8Color
        }
        "128" -> {
            bgColor = Game128Background
            color = Game8Color
        }
        "256" -> {
            bgColor = Game256Background
            color = Game8Color
        }
        "512" -> {
            bgColor = Game512Background
            color = Game8Color
        }
        "1024" -> {
            bgColor = Game1024Background
            color = Game8Color
        }
        "2048" -> {
            bgColor = Game2048Background
            color = Game8Color
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(bgColor).then(modifier)
    ) {
        Text(text = symbol, style = textStyle, fontSize = 36.sp, color = color)
    }
}