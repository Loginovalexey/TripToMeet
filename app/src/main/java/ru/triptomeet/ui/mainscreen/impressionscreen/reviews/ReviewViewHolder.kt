package ru.triptomeet.ui.mainscreen.impressionscreen.reviews

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_review.view.*
import ru.triptomeet.model.entity.detailedimpression.Review
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder
import ru.triptomeet.utils.getMonthNameByNumber

/**
 *  Класс для отрисовки элемента списка отзывов в соответствии с полученными данными
 */

class ReviewViewHolder(itemView: View) : BaseViewHolder<Review>(itemView) {

    override fun onBind(item: Review, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            reviewItemImage.load(item.imageId)
            reviewItemName.text = item.name
            reviewItemMonth.text = getMonthNameByNumber(item.month)
            reviewItemYear.text = item.year.toString()
            reviewItemText.text = item.content
        }
}
