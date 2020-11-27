package ru.triptomeet.ui.base.viewmodel//package ru.triptomeet.ui.base.old

import androidx.lifecycle.ViewModel
import ru.triptomeet.model.entity.Identifiable

/**
 * Обобщающий класс ViewModel
 */
abstract class BaseViewModel<Entity : Identifiable> :
    ViewModel() {
    /**
     * Получение данных
     */
    abstract fun fetch(): Any
}

