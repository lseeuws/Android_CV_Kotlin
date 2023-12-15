import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import network.QuizAPI

class QuizRepository()  {

    private val quizAPI = QuizAPI()
    private val repositoryBrut = repositoryBrut()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private var _questionState=  MutableStateFlow(listOf<Question>())
    var questionState = _questionState

    init {
        updateQuiz()
    }

    private suspend fun fetchQuiz(): List<Question> = quizAPI.getAllQuestions().questions

    private suspend fun fetchQuizRepositoryBrut() = repositoryBrut.getAllQuestions().questions

    private fun updateQuiz(){

        coroutineScope.launch {
            try {
                _questionState.update { fetchQuiz() }
            }
            catch (err: Exception) {
                _questionState.update { fetchQuizRepositoryBrut() }
            }
        }
    }
}


