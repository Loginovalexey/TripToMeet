package ru.triptomeet.ui.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/*
 * Внешние фунции для исключения дублирования кода в обоих видах адаптеров -
 * статичном и с пагинацией.
 */

/**
 * Формирование ViewHolder с заданным типом и макетом
 * @param parent Контейнер, в который помещается формируемый виджет
 * @param itemId Идентификатор макета виджета
 * @param viewHolderType Тип формируемого виджета
 **/
fun onCreateViewHolder(
    parent: ViewGroup,
    itemId: Int,
    viewHolderType: Class<*>
): RecyclerView.ViewHolder =
    viewHolderType.constructors[0]
        .newInstance(
            LayoutInflater.from(parent.context).inflate(itemId, parent, false)
        ) as RecyclerView.ViewHolder

/**
 * Связывание виджета с данными
 **/
fun <Entity> onBindViewHolder(holder: RecyclerView.ViewHolder, item: Entity, onItemClickListener: IOnItemClickListener?){
    (holder as BaseViewHolder<Entity>).onBind(item, onItemClickListener)
    }
