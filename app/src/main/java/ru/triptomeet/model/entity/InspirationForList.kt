package ru.triptomeet.model.entity

/**
 * "Вдохновение" с включением данных о количестве лайков и коментариев
 */

data class InspirationForList(
    override var id: Int,
    val imageId: Int,
    val title: String,
    val likesCount: Int,
    val commentsCount: Int
) : Identifiable()
