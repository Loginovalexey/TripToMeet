package ru.triptomeet.ui.mainscreen.home.locals

import ru.triptomeet.model.entity.Local
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс-"заглушка" с данными для отображения в слое "Местные жители"(Locals)
 * "домашнего" экрана (Home)
 */

class LocalsMockDataSource (private val locals: List<Local>) :
    StaticDataSource<Local>() {
    override suspend fun getData(): List<Local> = locals
}