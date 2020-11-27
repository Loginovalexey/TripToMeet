package ru.triptomeet.ui.mainscreen.home.info

import ru.triptomeet.R
import ru.triptomeet.model.entity.Info
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс-"заглушка" с данными для отображения в слое информационных иконок(InfoIcons)
 * "домашнего" экрана (Home)
 */

class InfoIconsMockDataSource : StaticDataSource<Info>() {
    override suspend fun getData(): List<Info> =
        listOf(
            Info(1, R.drawable.train),
            Info(2, R.drawable.moon),
            Info(3, R.drawable.plane),
            Info(4, R.drawable.cup),
            Info(5, R.drawable.present),
            Info(2, R.drawable.moon),
            Info(7, R.drawable.plane),
            Info(8, R.drawable.cup),
            Info(9, R.drawable.present),
            Info(1, R.drawable.train)
        )
}

