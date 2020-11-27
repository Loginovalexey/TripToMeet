package ru.triptomeet.ui.base.adapter

import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener


/**
 * Интерфейс, определяющий общие для адаптеров параметры
 * @property itemId идентификатор макета для элемента списка
 * @property viewHolderType тип, согласно которому формируется viewHolder
 * @property listener используется для обработки нажатий на элемент списка
 **/
interface IBaseAdapter{
    val itemId: Int
    val viewHolderType: Class<*>
    val listener: IOnItemClickListener?
}