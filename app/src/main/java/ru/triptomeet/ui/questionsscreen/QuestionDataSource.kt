package ru.triptomeet.ui.questionsscreen

import android.content.Context
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.R
import ru.triptomeet.model.entity.Question
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс с данными для отображения на экране "Путешествие для тебя" (QuestionsScreenFragment)
 */

class QuestionDataSource : StaticDataSource<Question>(),
    KoinComponent {
    val context: Context by inject()
    override suspend fun getData():List<Question> = listOf(
        Question(0,context.getString(R.string.walk), R.drawable.question_walk, model.isQuestionChecked(0)),
        Question(1, context.getString(R.string.beach), R.drawable.question_beach, model.isQuestionChecked(1)),
        Question(2, context.getString(R.string.photo), R.drawable.question_photo, model.isQuestionChecked(2)),
        Question(3, context.getString(R.string.dating), R.drawable.question_dating, model.isQuestionChecked(3)),
        Question(4, context.getString(R.string.nature), R.drawable.question_nature, model.isQuestionChecked(4)),
        Question(5, context.getString(R.string.food), R.drawable.question_food, model.isQuestionChecked(5)),
        Question(6,
            context.getString(R.string.shopping),
            R.drawable.question_shopping,
            model.isQuestionChecked(6)
        ),
        Question(7,
            context.getString(R.string.excursions),
            R.drawable.question_excursions,
            model.isQuestionChecked(7)
        ),
        Question(8,
            context.getString(R.string.unknown),
            R.drawable.question_unknown,
            model.isQuestionChecked(8)
        ),
        Question(9, context.getString(R.string.study), R.drawable.question_study, model.isQuestionChecked(9))
    )
}