package ru.triptomeet.ui.mainscreen.home.info

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_info.view.*
import ru.triptomeet.model.entity.Info
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки элемента списка информационных иконок в соответствии с полученными данными
 */

class InfoIconViewHolder(itemView: View) : BaseViewHolder<Info>(itemView) {

    override fun onBind(item: Info, onItemClickListener: IOnItemClickListener?): View {
        super.onBind(item, onItemClickListener)
        itemView.apply {
            infoItemImage.load(item.imageId)
        }
        return itemView
    }
}