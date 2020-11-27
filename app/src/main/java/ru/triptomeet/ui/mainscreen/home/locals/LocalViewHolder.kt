package ru.triptomeet.ui.mainscreen.home.locals

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_local.view.*
import ru.triptomeet.R


import ru.triptomeet.model.entity.Local
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Местные жители" в соответствии с полученными данными
 */

class LocalViewHolder(itemView: View) : BaseViewHolder<Local>(itemView) {
    override fun onBind(item: Local, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            localItemImage.load(item.imageId)
            localItemName.text = item.name
            localItemInterests.text = ""
            item.interests.forEach { localItemInterests.append("$it   ") }
            localItemTextView.text =
                (if (item.cost == 0) context.getString(R.string.free) else "${item.cost} ${
                    context.getString(
                        R.string.rubHour
                    )
                }")
        }
}
