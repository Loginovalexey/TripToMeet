package ru.triptomeet.ui.mainscreen.home.inspirations

import ru.triptomeet.model.entity.InspirationForGallery
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс-"заглушка" с данными для отображения в слое "Вдохновение" (Inspiration)
 * "домашнего" экрана (Home)
 */

class InspirationsMockDataSource (private val inspirations: List<InspirationForGallery>) :
    StaticDataSource<InspirationForGallery>() {
    override suspend fun getData(): List<InspirationForGallery> = inspirations
}
