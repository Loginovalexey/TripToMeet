package ru.triptomeet.ui.mainscreen.offersscreen

import android.view.View
import kotlinx.android.synthetic.main.item_offer.view.*
import ru.triptomeet.model.entity.Offer
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener


import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 * ViewHolder для связывания данных и визуальных элементов в списке "Мои предложения"
 */

class OfferScreenViewHolder(itemView: View) :
    BaseViewHolder<Offer>(itemView) {

    override fun onBind(item: Offer, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            super.onBind(item, onItemClickListener)
            offerItemTitle.text = item.title
            offerItemDescription.text = item.description
            offerItemCostText.text =
                (if (item.price == 0) "бесплатно" else "${item.price} руб/час")
        }
}