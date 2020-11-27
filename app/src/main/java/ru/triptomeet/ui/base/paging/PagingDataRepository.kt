package ru.triptomeet.ui.base.paging

import androidx.paging.*
import androidx.paging.PagingSource.LoadResult.Page.Companion.COUNT_UNDEFINED
import kotlinx.coroutines.flow.Flow
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.datasource.PagingDataSource

/**
 * Класс параметров пагинации
 */
class PagingDataRepository<Entity : Identifiable>
@ExperimentalPagingApi
constructor(private val pagingDataSource: PagingSource<Int,Entity>) {
    @ExperimentalPagingApi
    private val pagingConfig: PagingConfig =
        PagingConfig(
            pageSize = (pagingDataSource as PagingDataSource).pageSize,
            prefetchDistance = pagingDataSource.prefetchDistance,
            initialLoadSize = pagingDataSource.initialLoadSize,
            jumpThreshold = COUNT_UNDEFINED

        )

    @ExperimentalPagingApi
    fun letEntitiesFlow(): Flow<PagingData<Entity>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {pagingDataSource}
        ).flow
    }

}