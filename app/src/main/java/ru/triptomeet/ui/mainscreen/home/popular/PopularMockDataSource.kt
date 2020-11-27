package ru.triptomeet.ui.mainscreen.home.popular

import ru.triptomeet.model.entity.Popular
import ru.triptomeet.ui.base.datasource.StaticDataSource


/**
 * Класс-"заглушка" с данными для отображения в слое "Популярное" (Popular)
 * "домашнего" экрана (Home)
 */

class PopularMockDataSource (private val popular: List<Popular>) :
    StaticDataSource<Popular>() {
    override suspend fun getData(): List<Popular> = popular
}