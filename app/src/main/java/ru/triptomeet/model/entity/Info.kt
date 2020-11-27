package ru.triptomeet.model.entity

/**
 * Класс для информационных картинок экрана "Дом" (Home)
 */

data class Info(
    override var id: Int,
    val imageId: Int
) : Identifiable()
