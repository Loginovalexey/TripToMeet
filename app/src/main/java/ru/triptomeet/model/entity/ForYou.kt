package ru.triptomeet.model.entity

/**
 * "Для тебя"
 */

data class ForYou(
    override var id: Int,
    val imageId: Int,
    val title: String,
    val duration: Int,
    val cost: Int
) : Identifiable()