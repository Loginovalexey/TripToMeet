package ru.triptomeet.ui.mainscreen.home.foryou

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_for_you.view.*
import ru.triptomeet.model.entity.ForYou
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Для тебя" в соответствии с полученными данными
 */

class ForYouViewHolder(itemView: View) : BaseViewHolder<ForYou>(itemView) {

    override fun onBind(item: ForYou, onItemClickListener: IOnItemClickListener?) = itemView.apply {
        super.onBind(item, onItemClickListener)
        forYouItemImage.load(item.imageId)
        forYouItemTitle.text = item.title
        forYouItemDurationText.text = ("${item.duration} мин")
        forYouItemCostText.text = ("${item.cost} руб")
    }
}