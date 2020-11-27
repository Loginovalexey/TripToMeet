package ru.triptomeet.ui.mainscreen.home.foryou

import androidx.lifecycle.ViewModel
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.model.Model
import ru.triptomeet.model.entity.ForYou

/**
 * Класс используется для взаимодейтсвия с [Model]
 */

class ForYouViewModel : ViewModel(), KoinComponent {

    private val model: Model by inject()

    /**
     * Сохранение идентификатора выбранного элемента для последующего обращения к нему
     * из других объектов
     */
    fun saveForYou(forYou: ForYou) {
        model.currentAdvertId = forYou.id
    }
}


