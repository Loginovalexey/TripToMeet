package ru.triptomeet.model.entity

data class SearchLocation(
    override var id: Int,
    val location: String
) : Identifiable()