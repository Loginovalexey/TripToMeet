package ru.triptomeet.ui.searchlocation

import android.view.View
import kotlinx.android.synthetic.main.item_search_location.view.*
import ru.triptomeet.model.entity.SearchLocation
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

class SearchLocationViewHolder(itemView: View) : BaseViewHolder<SearchLocation>(itemView) {

    override fun onBind(item: SearchLocation, onItemClickListener: IOnItemClickListener?) =
        itemView.apply {
            searchItemText.text = item.location
        }
}