package ru.triptomeet.ui.mainscreen.home.foryou

import ru.triptomeet.model.entity.ForYou
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс-"заглушка" с данными для отображения в слое "Для тебя"(ForYou) "домашнего" экрана (Home)
 */


class ForYouMockDataSource (private val forYou: List<ForYou>) :
    StaticDataSource<ForYou>() {
    override suspend fun getData(): List<ForYou> = forYou
}