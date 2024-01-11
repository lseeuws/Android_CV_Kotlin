
class repositoryBrut {

    val quizzRepositoryBrut  = Quiz( listOf(
        Question(
            id = 0,
            label = "Android is great platform  ?",
            correctAnswerId = 1,
            answers = listOf(Answer(1, "Yes "), Answer(2, "No"),)
        ),
        Question(
            id = 1,
            label = "Capital du Brésil ?",
            correctAnswerId = 1,
            answers = listOf(Answer(1, "Brasília "), Answer(2, "Rio de Janeiro "),)
        ),
        Question(
            id = 2,
            label = "Quel est la couleur du cheval blanc de Henri IV ?",
            correctAnswerId = 2,
            answers = listOf(Answer(1, "blanc "), Answer(2, "gris"),)
        ),
        Question(
            id = 3,
            label = "Wie lange ?",
            correctAnswerId = 2,
            answers = listOf(Answer(1, "Wo"), Answer(2, "Warum"),)
        ),
        Question(
            id = 4,
            label = "Cual es la fecha de hoy ?",
            correctAnswerId = 1,
            answers = listOf(Answer(1, "Viernes "), Answer(2, "Jueves "),)
        ),
        Question(
            id = 5,
            label = "잘 지내요? ?",
            correctAnswerId = 1,
            answers = listOf(Answer(1, "예 "), Answer(2, "비 "),)
        ),
    )
    )


    suspend fun getAllQuestions(): Quiz {
        try {
            return quizzRepositoryBrut
        } catch (err: Exception) {
            return throw err
        }
    }



}