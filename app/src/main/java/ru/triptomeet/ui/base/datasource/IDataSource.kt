package ru.triptomeet.ui.base.datasource

import org.koin.standalone.KoinComponent
import ru.triptomeet.application.retrofit.ApiClient
import ru.triptomeet.model.Model

/**
 * Интерфейс с общими элекментами для реализации источников данных
 **/
interface IDataSource : KoinComponent {
    /**
     * Элемент, реализующий запросы в сеть, используя библиотеку Retrofit2
     **/
    val apiClient: ApiClient

    /**
     * Model необходима для получения параметров запросов. Например,
     * там хранится токен пользователя
     */
    val model: Model
}