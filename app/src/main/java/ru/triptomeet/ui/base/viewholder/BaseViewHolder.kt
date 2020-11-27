package ru.triptomeet.ui.base.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.ui.base.onitemclicklistener.*

/**
 * Обобщенный класс ViewHolder
 */

abstract class BaseViewHolder<Entity>(itemView: View) :
    RecyclerView.ViewHolder(itemView)
{
    /**
     * Установка слушателя на нажатие всего элемента списка
     */
    open fun onBind(item:Entity, onItemClickListener: IOnItemClickListener?): View {
        if (onItemClickListener!=null && (onItemClickListener is IOnItemClickListenerForView<*>)){
            itemView.setOnClickListener {
                (onItemClickListener as IOnItemClickListenerForView<Entity>).onItemClick(item,itemView)
            }
        }
        return itemView
    }

    /**
     * Установка слушателя на нажатие конкретного виджета внутри элемента списка
     */
    fun setClickListenerForView(item: Entity, view: View, onItemClickListener: IOnItemClickListener?) {
        itemView.setOnClickListener(null)
        view.setOnClickListener{
            (onItemClickListener as IOnItemClickListenerForView<Entity>).onItemClick(item,view)
        }
    }
}