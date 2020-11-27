package ru.triptomeet.model.entity.detailedimpression

import ru.triptomeet.model.entity.Identifiable

/**
 * Класс отзыва для экрана "Впечатление" (Impression)
 */

class Review(
    override var id: Int,
    val imageId: Int,
    val name: String,
    val month: Int,
    val year: Int,
    val content:String
) : Identifiable()
