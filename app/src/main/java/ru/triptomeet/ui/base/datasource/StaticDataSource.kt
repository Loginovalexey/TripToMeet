package ru.triptomeet.ui.base.datasource

import org.koin.standalone.inject
import ru.triptomeet.application.retrofit.ApiClient
import ru.triptomeet.model.Model

/**
 * Класс с иточниками данных для статических списков
 * @property apiClient - Внедрение объекта [ApiClient] для получения данных из сети
 * с ипользованием библиотеки Retrofit2
 * @property model Внедрение объекта класса [Model]
 */
abstract class StaticDataSource<Entity> : IDataSource{
    override val apiClient: ApiClient by inject()
    override val model: Model by inject()

    /**
     * В классах-наследниках должна быть конкретизирована функция для получения данных
     */
    abstract suspend fun getData(): List<Entity>
}