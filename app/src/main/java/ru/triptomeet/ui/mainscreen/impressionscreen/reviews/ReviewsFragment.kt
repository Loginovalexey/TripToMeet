package ru.triptomeet.ui.mainscreen.impressionscreen.reviews

import ru.triptomeet.R
import ru.triptomeet.model.entity.detailedimpression.Review
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Список "Отзывы" на экране "Впечатление" (Impression)
 */

class ReviewsFragment(entitiesSource: IDataSource) : StaticBaseFragment<Review>(
    itemId = R.layout.item_review,
    containerId = R.id.reviewsList,
    fragmentId = R.layout.layer_reviews,
    viewHolderType = ReviewViewHolder::class.java,
    entitiesSource = entitiesSource
)