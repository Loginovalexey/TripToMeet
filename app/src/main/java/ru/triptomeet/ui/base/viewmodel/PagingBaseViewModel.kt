package ru.triptomeet.ui.base.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.paging.PagingDataRepository
import ru.triptomeet.ui.base.datasource.PagingDataSource

@ExperimentalPagingApi

/**
 * Реализация ViewModel для списков с пагинацией
 */
class PagingBaseViewModel<Entity : Identifiable>(
    val entitiesSource: PagingDataSource<Entity>
) : BaseViewModel<Entity>() {

    /**
     * Данные формируются в классе [PagingDataRepository] на основе функции getData, заложенной в
     * [PagingDataSource]
     */
    override fun fetch() =
        (PagingDataRepository(entitiesSource)
            .letEntitiesFlow()
            .cachedIn(viewModelScope))
}