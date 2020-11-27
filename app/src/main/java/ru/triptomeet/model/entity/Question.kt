package ru.triptomeet.model.entity

/**
 * Категория развлечений
 */

data class Question(
    override var id: Int,
    val text: String,
    val imageId: Int,
    var check: Boolean
) : Identifiable()