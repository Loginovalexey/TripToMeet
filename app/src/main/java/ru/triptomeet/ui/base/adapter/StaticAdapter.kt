package ru.triptomeet.ui.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener

/** Класс адаптера для использования в статичных списках(без пагинации).
 * @param itemId идентификатор макета для элемента списка
 * @param viewHolderType тип, согласно которому формируется viewHolder
 * @param listener используется для обработки нажатий на элемент списка
 **/
class StaticAdapter<Entity : Identifiable>(
    val items: List<Entity>?,
    override val itemId: Int,
    override val viewHolderType: Class<*>,
    override val listener: IOnItemClickListener?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), IBaseAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        //вызывается внешняя фунция с общим кодом для адаптеров разных типов
        onCreateViewHolder(parent, itemId, viewHolderType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        //вызывается внешняя фунция с общим кодом для адаптеров разных типов
        onBindViewHolder(holder, getItem(position), listener)

    override fun getItemCount() = items?.size ?: 0

    private fun getItem(position: Int) = items?.get(position)

}
