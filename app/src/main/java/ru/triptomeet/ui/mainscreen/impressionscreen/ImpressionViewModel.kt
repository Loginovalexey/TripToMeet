package ru.triptomeet.ui.mainscreen.impressionscreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.flow
import org.koin.standalone.KoinComponent
import ru.triptomeet.ui.base.DataResult

class ImpressionViewModel : ViewModel(), KoinComponent {

    private val impressionDataSource = ImpressionMockDataSource()

    /**
     * Передача данных
     */
    fun fetch() = flow {
        emit(DataResult.Loading(true))
        try {
            emit(DataResult.SuccessAny(impressionDataSource.getData()))
        } catch (e: Exception) {
            emit(DataResult.Error(e))
            e.printStackTrace()
        }
        emit(DataResult.Loading(false))
    }

}