package ru.triptomeet.ui.base.viewmodel

import kotlinx.coroutines.flow.flow
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.DataResult
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Реализация ViewModel для статических списков без пагинации
 */

class StaticBaseViewModel<Entity : Identifiable>(
    val entitiesSource: IDataSource
) :
    BaseViewModel<Entity>() {

    /**
     * Получение данных
     */
    override fun fetch() = flow {
        emit(DataResult.Loading(true))
        try {
            emit(DataResult.Success((entitiesSource as StaticDataSource<*>).getData()))
        } catch (e: Exception) {
            emit(DataResult.Error(e))
            e.printStackTrace()
        }
        emit(DataResult.Loading(false))
    }
}