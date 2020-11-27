package ru.triptomeet.model.entity

data class Home(
    val imageId: Int,
    val title: String,
    val forYou: List<ForYou>?,
    val inspirations: List<InspirationForGallery>?,
    val popular: List<Popular>?,
    val locals: List<Local>?,
)