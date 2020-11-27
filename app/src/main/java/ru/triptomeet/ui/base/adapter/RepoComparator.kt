package ru.triptomeet.ui.base.adapter

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.triptomeet.model.entity.Identifiable

/**
 * Класс используется в адаптере с пагинацией [PagingDataAdapter]
 * для оптимизации прокрутки списка при повторении элементов.
 * Элементы списка должны быть типа [Identifiable] для сравнения по идентификатору
 **/
class RepoComparator : DiffUtil.ItemCallback<Identifiable>() {
    //Проверка на идентичность элементов
    override fun areItemsTheSame(oldItem: Identifiable, newItem: Identifiable): Boolean =
        oldItem.id == newItem.id

    //Провеока на идентичность контента
    override fun areContentsTheSame(oldItem: Identifiable, newItem: Identifiable): Boolean =
        oldItem.id == newItem.id
}