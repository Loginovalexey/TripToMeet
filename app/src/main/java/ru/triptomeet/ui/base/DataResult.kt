package ru.triptomeet.ui.base

/**
 * Класс получения данных: успех, загрузка, ошибка
 */
sealed class DataResult{

    data class Success<out Entity>(val data: List<Entity>?) : DataResult()

    data class SuccessAny<out Any>(val data: Any?) : DataResult()

    data class Error(val error: Throwable) : DataResult()

    data class Loading(val isLoading: Boolean) : DataResult()
}

