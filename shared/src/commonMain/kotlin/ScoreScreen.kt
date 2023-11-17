import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
public fun ScoreScreen(score: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.background(color = Color.Black).fillMaxSize()) {
        Card(){
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.Green).padding(10.dp,2.dp,10.dp,10.dp)) {
                Text( "Score", color = Color.Black, fontSize = 15.sp)
                Text( score, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
               Button(onClick = {
                }) {Text("Retake the quizz")
                }

            }
        }
    }
}