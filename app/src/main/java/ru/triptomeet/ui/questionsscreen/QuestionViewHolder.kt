package ru.triptomeet.ui.questionsscreen

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_question.view.*
import ru.triptomeet.model.entity.Question
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Популярное" в соответствии с полученными данными
 */

class QuestionViewHolder(itemView: View) : BaseViewHolder<Question>(itemView) {

    override fun onBind(item: Question, onItemClickListener: IOnItemClickListener?)=
        itemView.apply {
            super.onBind(item, onItemClickListener)
            questionItemImage.load(item.imageId)
            questionItemTitle.text = item.text
            if (item.check) questionItemCheckImage.visibility = View.VISIBLE
            else questionItemCheckImage.visibility = View.GONE
        }
    }
