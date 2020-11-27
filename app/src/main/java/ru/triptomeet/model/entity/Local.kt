package ru.triptomeet.model.entity

/**
 * "Местный житель"
 */

data class Local(
    override var id: Int,
    val imageId: Int,
    val name: String,
    var interests: List<String>,
    val cost: Int
) : Identifiable()