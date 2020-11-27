package ru.triptomeet.ui.mainscreen.home.popular

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_popular.view.*
import ru.triptomeet.model.entity.Popular
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка "Популярное" в соответствии с полученными данными
 */

class PopularViewHolder(itemView: View) : BaseViewHolder<Popular>(itemView) {
    override fun onBind(item: Popular, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            popularItemImage.popularItemImage.load(item.imageId)
            popularItemTitle.text = item.title
            popularItemDurationText.text = ("${item.duration} мин")
            popularItemCostText.text = ("${item.cost} руб")
        }
}