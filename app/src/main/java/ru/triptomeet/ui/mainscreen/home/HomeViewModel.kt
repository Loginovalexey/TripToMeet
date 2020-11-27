package ru.triptomeet.ui.mainscreen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.flow
import org.koin.standalone.KoinComponent
import ru.triptomeet.ui.base.DataResult

/**
 * View Model для заполнения данными домашнего экрана
 */

class HomeViewModel : ViewModel(), KoinComponent {

    private val homeMockDataSource = HomeMockDataSource()

    /**
     * Передача данных
     */
    fun fetch() = flow {
        emit(DataResult.Loading(true))
        try {
            emit(DataResult.SuccessAny(homeMockDataSource.getData()))
        } catch (e: Exception) {
            emit(DataResult.Error(e))
            e.printStackTrace()
        }
        emit(DataResult.Loading(false))
    }

}