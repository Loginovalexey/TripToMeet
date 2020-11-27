package ru.triptomeet.model.entity.detailedimpression

import ru.triptomeet.model.entity.Identifiable

/**
 * Данные об организаторе для экрана "Впечатление" (Impression)
 */

class ImpressionLocal(
    override var id: Int,
    val imageId: Int,
    val name: String,
    val month: Int,
    val year: Int,
    val likesCount: Int,
    val commentsCount: Int
) : Identifiable()