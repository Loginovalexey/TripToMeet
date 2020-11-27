package ru.triptomeet.ui.questionsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.model.Model

/**
 * Дополнительная ViewModel для обработки нажатий на элементы и их перерисовки
 */


class ClickQuestionsViewModel : ViewModel(), KoinComponent {

    private val model: Model by inject()

    //Канал используется для передачи во фрагмент данных о нажатых элементах
    @ExperimentalCoroutinesApi
    private val viewStateChannel =
        BroadcastChannel<Pair<Int, Boolean>>(Channel.CONFLATED)

    //Канал используется для активации/деактивации кнопки "Продолжить" в зависимости от того -
    //есть или нет нажатые элементы
    @ExperimentalCoroutinesApi
    private val questionsCheckedChannel =
        BroadcastChannel<Boolean>(Channel.CONFLATED)

    @ExperimentalCoroutinesApi
    fun getViewState() = viewStateChannel.openSubscription()

    @ExperimentalCoroutinesApi
    fun getQuestionsCheckedState() = questionsCheckedChannel.openSubscription()

    //Получаемые от Model данные преобразуются для показа во фрагменте и отправляются туда
    @ExperimentalCoroutinesApi
    fun checkElement(id: Int) {
        model.checkQuestion(id)
        viewModelScope.launch {
            viewStateChannel.send(
                Pair(
                    id,
                    model.isQuestionChecked(id)
                )
            )
        }
        isQuestionsChecked()
    }

    @ExperimentalCoroutinesApi
    fun isQuestionsChecked() {
        viewModelScope.launch {
            questionsCheckedChannel.send(model.checkedQuestions.isEmpty())
        }
    }
}