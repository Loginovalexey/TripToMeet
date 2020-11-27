package ru.triptomeet.model.entity

/**
 * "Вдохновение"
 */

data class InspirationForGallery(
    override var id: Int,
    val imageId: Int,
    val title: String,
) : Identifiable()

