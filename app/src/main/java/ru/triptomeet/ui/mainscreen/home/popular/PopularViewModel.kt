package ru.triptomeet.ui.mainscreen.home.popular

import androidx.lifecycle.ViewModel
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.model.Model
import ru.triptomeet.model.entity.Popular

/**
 * Класс используется для взаимодейтсвия с [Model]
 */

class PopularViewModel : ViewModel(), KoinComponent {

    private val model: Model by inject()

    /**
     * Сохранение идентификатора выбранного элемента для последующего обращения к нему
     * из других объектов
     */
    fun savePopular(popular: Popular) {
        model.currentAdvertId = popular.id
    }
}