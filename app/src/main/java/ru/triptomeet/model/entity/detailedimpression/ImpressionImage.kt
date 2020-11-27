package ru.triptomeet.model.entity.detailedimpression

import ru.triptomeet.model.entity.Identifiable

/**
 * Класс изображения для галереи картинок экрана "Впечатление" (Impression)
 */
data class ImpressionImage(
    override var id: Int,
    val imageId: Int
) : Identifiable()