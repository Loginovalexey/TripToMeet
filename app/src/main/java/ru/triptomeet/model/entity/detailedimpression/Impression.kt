package ru.triptomeet.model.entity.detailedimpression

/**
 *  Объект этого класса выводится на экран "Впечатление" (Impression)
 */

data class Impression(
    val imageId: Int,
    val title: String,
    val mainDescription: String,
    val local: ImpressionLocal,
    val description1: String?,
    val images: List<ImpressionImage>?,
    val description2: String?,
    val spinnerOptions: List<Pair<String, String?>>,
    val comments: List<Review>?
)