package ru.triptomeet.ui.mainscreen.impressionscreen.reviews

import ru.triptomeet.model.entity.detailedimpression.Review
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Объект этого класса передается в конструктор класса CommentsFragment для показа данных в разделе
 * отзывов.
 */

class ReviewsDataSource(private val reviews: List<Review>) :
    StaticDataSource<Review>() {
    override suspend fun getData(): List<Review> = reviews
}