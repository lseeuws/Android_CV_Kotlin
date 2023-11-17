import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
public fun welcomeScreen(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.background(color = Color.Black).fillMaxSize()) {
        Card(shape = RoundedCornerShape(10.dp)){
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White)) {
                Text( "Quizz", color = Color.Black, fontSize = 25.sp)
                Text( "A simple Quizz to discovers KMP, KMM and compose", color = Color.Black, fontSize = 20.sp)
                Button(onClick = {
                }) {
                    Text("Start the Quizz")
                }
            }
        }
    }
}