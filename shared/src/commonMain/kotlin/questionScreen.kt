import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun questionScreen(questions: List<Question>) {
    var idQuestion by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(1) }
    var progress by remember { mutableStateOf(0.00f) }
    var goodAnswer by remember { mutableStateOf(0) }
    var endQuestion by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    if (selectedAnswer == questions[idQuestion].correctAnswerId && !endQuestion){
                        goodAnswer++;
                        selectedAnswer=1;
                    }
                    if ((idQuestion +1 < questions.size)){
                        idQuestion++;
                        progress += 0.18f;
                    }
                    else {
                        endQuestion = true;
                        progress += 0.18f;
                    }
                }) {
                    Text(if (endQuestion) "Fin" else "-> Next")
                }
                if (!endQuestion) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(20.dp), progress = progress);
                    Text("Bonne réponses: $goodAnswer", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(top = 8.dp));
                }
            }
        }
    ) {
        if (!endQuestion) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.DarkGray).fillMaxSize()) {
                Card(modifier = Modifier.padding(top = 20.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White).padding(10.dp, 2.dp, 10.dp, 10.dp)) {
                            Text(questions[idQuestion].label, color = Color.Black, fontSize = 20.sp);
                        }
                    }

                questions[idQuestion].answers.forEach { answer ->
                    Row {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = selectedAnswer == answer.id,
                            onClick = { selectedAnswer = answer.id }
                        );
                        Text(answer.label, color = Color.White, fontSize = 20.sp);
                    }
                }
            }
        }
        else {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.background(color = Color.DarkGray).fillMaxSize()) {
                Card(modifier = Modifier.padding(top = 20.dp)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White).padding(10.dp, 2.dp, 10.dp, 10.dp)) {
                        Text("Vous avez obtenu un score de $goodAnswer !" , color = Color.Black, fontSize = 20.sp);
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            idQuestion = 0
                            selectedAnswer = 1
                            progress = 0.00f
                            goodAnswer = 0
                            endQuestion = false
                        }) {
                            Text("Recommencer")
                        }
                    }
                }
            }
        }
    }
}