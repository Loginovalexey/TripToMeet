package ru.triptomeet.ui.mainscreen.offersscreen

import androidx.paging.ExperimentalPagingApi
import ru.triptomeet.model.entity.Offer
import ru.triptomeet.ui.base.datasource.PagingDataSource


/**
 * Класс, определяющий источник данных для списка "Мои предложения".
 */
@ExperimentalPagingApi
class OffersPagingDataSource : PagingDataSource<Offer>() {

    //Список с данными запрашивается вызовом метода getAdverts с параметрами пагинации
    override suspend fun getData(page: Int, loadSize: Int): List<Offer> =
        apiClient.apiService.getOffer(
            model.authToken,
            model.userId,
            page,
            loadSize
        )
}