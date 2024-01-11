import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//Il faudrait faire une requete pour allez chercher de manière random un film puis stocker la valeur
//Il faut également en fonction de ce film chercher des indices également de manière random


var searchResults by mutableStateOf<List<String>>(emptyList()) //liste de réponses fausses de l'utilisateur
var searchText by mutableStateOf<String>("") //valeur entrée par l'utilisateur
var hintBlocks by mutableStateOf<List<String>>(listOf("Indice 1","Indice 2","Indice 3","Indice 4","Indice 5")) //bloc de texte pour les indices

@Composable
fun questionScreen(questions: List<Question>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000080))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, color = Color.White, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White),
                placeholder = { Text("Taper le nom du film") },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        search(searchText)
                        searchText = ""
                    }
                )
            )
        }

        hintBlocks.take(searchResults.size).forEach { hintBlock ->
            Text(
                text = hintBlock,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }

        if (searchResults.isNotEmpty()) {
            Text(
                text = "Réponses :",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF000080))
        ) {
            items(searchResults.reversed()) { result ->
                Text(
                    text = result,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

fun search(searchText: String?) {
    val filmStarWars = "A New Hope"
    if (!searchText.isNullOrBlank() && !searchText.equals(filmStarWars, ignoreCase = true)) {
        println("Ce n'est pas le bon film : $searchText")

        if (hintBlocks.size < 5) { //A chaque fois que l'utilisateur rentre une mauvaise réponse alors
            hintBlocks += "Nouvel indice pour \"$searchText\"" //on dévoile un indice (il faut faire la logique de récupération)
        }
        searchResults = (searchResults + searchText).distinct()
    }
}

//    var idQuestion by remember { mutableStateOf(0) }
//    var selectedAnswer by remember { mutableStateOf(1) }
//    var progress by remember { mutableStateOf(0.00f) }
//    var goodAnswer by remember { mutableStateOf(0) }
//    var endQuestion by remember { mutableStateOf(false) }
//
//    Scaffold(
//        bottomBar = {
//            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
//                Button(onClick = {
//                    if (selectedAnswer == questions[idQuestion].correctAnswerId && !endQuestion){
//                        goodAnswer++;
//                        selectedAnswer=1;
//                    }
//                    if ((idQuestion +1 < questions.size)){
//                        idQuestion++;
//                        progress += 0.18f;
//                    }
//                    else {
//                        endQuestion = true;
//                        progress += 0.18f;
//                    }
//                }) {
//                    Text(if (endQuestion) "Fin" else "-> Next")
//                }
//                if (!endQuestion) {
//                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(20.dp), progress = progress);
//                    Text("Bonne réponses: $goodAnswer", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(top = 8.dp));
//                }
//            }
//        }
//    ) {
//        if (!endQuestion) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.DarkGray).fillMaxSize()) {
//                Card(modifier = Modifier.padding(top = 20.dp)) {
//                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White).padding(10.dp, 2.dp, 10.dp, 10.dp)) {
//                            Text(questions[idQuestion].label, color = Color.Black, fontSize = 20.sp);
//                        }
//                    }
//                questions[idQuestion].answers.forEach { answer ->
//                    Row {
//                        RadioButton(
//                            modifier = Modifier.padding(end = 16.dp),
//                            selected = selectedAnswer == answer.id,
//                            onClick = { selectedAnswer = answer.id }
//                        );
//                        Text(answer.label, color = Color.White, fontSize = 20.sp);
//                    }
//                }
//            }
//        }
//        else {
//            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.background(color = Color.DarkGray).fillMaxSize()) {
//                Card(modifier = Modifier.padding(top = 20.dp)) {
//                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White).padding(10.dp, 2.dp, 10.dp, 10.dp)) {
//                        Text("Vous avez obtenu un score de $goodAnswer !" , color = Color.Black, fontSize = 20.sp);
//                        Spacer(modifier = Modifier.height(16.dp))
//                        Button(onClick = {
//                            idQuestion = 0
//                            selectedAnswer = 1
//                            progress = 0.00f
//                            goodAnswer = 0
//                            endQuestion = false
//                        }) {
//                            Text("Recommencer")
//                        }
//                    }
//                }
//            }
//        }
//    }
//}