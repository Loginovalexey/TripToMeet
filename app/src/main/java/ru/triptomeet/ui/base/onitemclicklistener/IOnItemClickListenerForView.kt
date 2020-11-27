package ru.triptomeet.ui.base.onitemclicklistener

import android.view.View

/**
 * Интерфейс нажатия на элеиент списка с получением данных нажатого элемента и
 * типа нажатого виджета
 */
interface IOnItemClickListenerForView<Entity> :IOnItemClickListener
{
    fun onItemClick (item:Entity, view: View)
}