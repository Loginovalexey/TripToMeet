package ru.triptomeet.ui.base.datasource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import org.koin.standalone.inject
import retrofit2.HttpException
import ru.triptomeet.application.Constants.DEFAULT_INITIAL_LOAD_SIZE
import ru.triptomeet.application.Constants.DEFAULT_PAGE_INDEX
import ru.triptomeet.application.Constants.DEFAULT_PAGE_SIZE
import ru.triptomeet.application.Constants.DEFAULT_PREFETCH_DISTANCE
import ru.triptomeet.application.retrofit.ApiClient
import ru.triptomeet.model.Model
import ru.triptomeet.model.entity.Identifiable
import java.io.IOException

/**
 * Класс с иточниками данных для списков c с пагинацией
 * @property apiClient - Внедрение объекта [ApiClient] для получения данных из сети
 * с ипользованием библиотеки Retrofit2
 *
 * @property model Внедрение объекта класса [Model]
 **/
@ExperimentalPagingApi
abstract class PagingDataSource<Entity : Identifiable> :
/**
 * @see [PagingSource]
 */
    PagingSource<Int, Entity>(), IDataSource {
    /**
     * Размер загружаемых страниц
     */
    val pageSize = DEFAULT_PAGE_SIZE

    /**
     * Когда при прокрутке до конца списка остается заданное количество элементов, загружается
     * следующая страница
     */
    open val prefetchDistance = DEFAULT_PREFETCH_DISTANCE

    /**
     * Количество элементов при первичной загрузке
     */
    open val initialLoadSize = DEFAULT_INITIAL_LOAD_SIZE

    override val apiClient: ApiClient by inject()

    override val model: Model by inject()

    /**
     * Именно эта функция, реализуемая в наследниках, определяет источник данных с использованием
     * пагинации
     */
    abstract suspend fun getData(page: Int, loadSize: Int): List<Entity>
    /*
    * Загрузка очередной страницы
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Entity> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val entitiesList = getData(
                page,
                params.loadSize
            )
            /**
             * Загрузка очередной страницы с использованием фунции для получения данных,
             * определенной в классе-наследнике
             */
            LoadResult.Page(
                entitiesList,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (entitiesList.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}