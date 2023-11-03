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
    val userData = informations()
    MaterialTheme {
        Row(Modifier.fillMaxWidth()) {
            LeftColumn(userData)
            Spacer(modifier = Modifier.padding(10.dp).background(color = Color.Cyan))
            RightColumn(userData)
        }
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

expect fun getPlatformName(): String