package ru.triptomeet.ui.base.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener

/**
 * Класс адаптера для списков c пагинацией.
 * @constructor Используются параметры, определенные в общем для адаптеров интерфейсе [IBaseAdapter]
 **/

class PagingAdapter<Entity : Identifiable>(
    override val itemId: Int,
    override val viewHolderType: Class<*>,
    override val listener: IOnItemClickListener?
) :
/**
 ** Функциональность пагинации определяется классом-предком [PagingDataAdapter]
 */
    PagingDataAdapter<Entity, RecyclerView.ViewHolder>(
        RepoComparator() as DiffUtil.ItemCallback<Entity>
    ),
    IBaseAdapter{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        //вызывается внешняя фунция с общим кодом для адаптеров разных типов
        onCreateViewHolder(parent, itemId, viewHolderType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        //вызывается внешняя фунция с общим кодом для адаптеров разных типов
        onBindViewHolder(holder, getItem(position)!!, listener)
}