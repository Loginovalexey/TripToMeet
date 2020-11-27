package ru.triptomeet.ui.mainscreen.inspirationsscreen

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_inspiration.view.*


import ru.triptomeet.model.entity.InspirationForList
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Вдохновение" в соответствии с полученными данными
 */

class InspirationViewHolder(itemView: View) :
    BaseViewHolder<InspirationForList>(itemView) {

    override fun onBind(item: InspirationForList, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            inspirationItemImage.load(item.imageId)
            inspirationItemTitle.text = item.title
            inspirationItemLikeText.text = item.likesCount.toString()
            inspirationItemCommentText.text = item.commentsCount.toString()
    }

}