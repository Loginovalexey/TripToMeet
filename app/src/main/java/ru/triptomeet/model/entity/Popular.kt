package ru.triptomeet.model.entity

/**
 * "Популярное"
 */

data class Popular(
    override var id: Int,
    val imageId: Int,
    val title: String,
    val duration: Int,
    val cost: Int
) : Identifiable()