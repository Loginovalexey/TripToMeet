package ru.triptomeet.ui.mainscreen.home.inspirations

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_inspiration_short.view.*
import ru.triptomeet.model.entity.InspirationForGallery
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Вдохновение" в соответствии с полученными данными
 */

class InspirationViewHolder(itemView: View) :
    BaseViewHolder<InspirationForGallery>(itemView) {

    override fun onBind(item: InspirationForGallery, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            shortInspirationItemImage.load(item.imageId)
            shortInspirationItemTitle.text = item.title
        }
}
