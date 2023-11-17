import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {


    //Exercice CV

//    val userData = informations()
//    MaterialTheme {
//        Row(Modifier.fillMaxWidth()) {
//            LeftColumn(userData)
//            Spacer(modifier = Modifier.padding(10.dp).background(color = Color.Cyan))
//            RightColumn(userData)
//        }
//    }


    // Exercice Quizz

    val quizzQuestions = listOf(
        Question(id = 0, label = "Android is great platform  ?", correctAnswerId = 1, answers = listOf(Answer(1, "Yes "), Answer(2, "No"),)),
        Question(id = 1, label = "Capital du Brésil ?", correctAnswerId = 1, answers = listOf(Answer(1, "Brasília "), Answer(2, "Rio de Janeiro "),)),
        Question(id = 2, label = "Quel est la couleur du cheval blanc de Henri IV ?", correctAnswerId = 2, answers = listOf(Answer(1, "blanc "), Answer(2, "gris"),)),
        Question(id = 3, label = "Wie lange ?", correctAnswerId = 2, answers = listOf(Answer(1, "Wo"), Answer(2, "Warum"),)),
        Question(id = 4, label = "Cual es la fecha de hoy ?", correctAnswerId = 1, answers = listOf(Answer(1, "Viernes "), Answer(2, "Jueves "),)),
        Question(id = 5, label = "잘 지내요? ?", correctAnswerId = 1, answers = listOf(Answer(1, "예 "), Answer(2, "비 "),)),
        )
        MaterialTheme {
//          welcomeScreen();
//          ScoreScreen("10/20");
            questionScreen(questions = quizzQuestions)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun LeftColumn(userData: informations) {
    MaterialTheme {
        Column(modifier = Modifier.background(color = Color.Cyan).fillMaxHeight().verticalScroll(rememberScrollState())) {
            Image(
                painterResource("compose-multiplatform.xml"),
                contentDescription = "Compose Multiplatform icon",
                Modifier
                    .size(150.dp)
                    .border(2.dp, Color.White, CircleShape)
            )
            Text( "Louis Seeuws", color = Color.Black, fontSize = 15.sp)
            Text(text = "Apprenti développeur FullStack")
            CompetenceList("${userData.competenceLangue}", userData.languagesCompetence)
//            BoxParagraphe("${userData.formation}", "${userData.formationList}")
        }
    }
}

@Composable
internal fun RightColumn(userData: informations) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        BoxParagraphe("${userData.experience}", "${userData.experienceText}")
        BoxParagraphe("${userData.project}", "${userData.projectText}")
        CompetenceList("${userData.competence}", userData.competenceText)
    }
}

@Composable
internal fun BoxParagraphe(entete:String, text:String ) {
    MaterialTheme {
        Column() {
            Text( entete, color = Color.Black, fontSize = 30.sp,  textDecoration = TextDecoration.Underline)
            Text(text, color = Color.Black )
        }
    }
}

@Composable
fun CompetenceList(competenceTitre: String, competenceText: List<Pair<String, Int>>) {
    Column {
        Text(competenceTitre, color = Color.Black, fontSize = 30.sp, textDecoration = TextDecoration.Underline)
        competenceText.forEach { (competence, valeur) ->
            ListItem(competence, valeur)
        }
    }
}

@Composable
fun ListItem(competence: String, valeur: Int) {
    val textX = "X".repeat(valeur)
    Text(
        "$competence : $textX",
        color = Color.Black,
        fontSize = 15.sp,
    )
}



@Composable
fun quizz(){
    Card(){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text( "Quizz", color = Color.Black, fontSize = 15.sp)
            Text( "A simple Quizz to discovers KMP, KMM and compose", color = Color.Black, fontSize = 15.sp)
            Button(onClick = {
            }) {
                Text("Start the Quizz")
            }
        }
    }

}

expect fun getPlatformName(): String