package ru.triptomeet.ui.questionsscreen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.screen_questions.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.triptomeet.R
import ru.triptomeet.model.entity.Question
import ru.triptomeet.ui.IOnBackPressed
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.base.fragment.StaticBaseFragment
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListenerForView
import ru.triptomeet.ui.mainscreen.MainScreenFragment


/**
 * Реализация экрана "Путешествие для тебя"
 */

class QuestionsScreenFragment : StaticBaseFragment<Question>(
    fragmentId = R.layout.screen_questions,
    containerId = R.id.questionsRecycler,
    itemId = R.layout.item_question,
    entitiesSource = QuestionDataSource(),
    viewHolderType = QuestionViewHolder::class.java

), IOnBackPressed, IOnItemClickListenerForView<Question>
{
    private val clickQuestionsViewModel: ClickQuestionsViewModel by inject()

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //слушатель данных об элементах списка
        lifecycleScope.launch {
            clickQuestionsViewModel
                .getViewState().consumeEach {
                    val item = getItem<Question>(it.first)
                    (item as Question).check = it.second
                    changeItem(it.first, item)
                }
        }

        //слушатель данных о необходимости активировать/деактивировать кнопку "Продолжить"
        lifecycleScope.launch {
            clickQuestionsViewModel.getQuestionsCheckedState().consumeEach {
                continueButton.isEnabled = !it
            }
        }

        clickQuestionsViewModel.isQuestionsChecked()

        continueButton.setOnClickListener {
            (requireActivity() as IOnCallChangeScreen).replaceFragment(MainScreenFragment())
        }
    }


    override fun pressBack() {
        requireActivity().finish()
    }

    //Действия при нажатии на элемент списка
    @ExperimentalCoroutinesApi
    override fun onItemClick(item: Question, view:View) {
        clickQuestionsViewModel.checkElement(item.id)
    }

}
