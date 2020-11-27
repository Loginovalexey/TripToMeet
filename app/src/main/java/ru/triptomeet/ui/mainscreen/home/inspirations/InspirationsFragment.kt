package ru.triptomeet.ui.mainscreen.home.inspirations

import ru.triptomeet.R
import ru.triptomeet.model.entity.InspirationForGallery
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Фрагмент-список "Вдохновение" на "домашнем" экране (Home)
 */

class InspirationsFragment(entitiesSource: IDataSource)  : StaticBaseFragment<InspirationForGallery>(
    itemId = R.layout.item_inspiration_short,
    containerId = R.id.inspirationsLayerRecycler,
    fragmentId = R.layout.layer_main_inspirations,
    viewHolderType = InspirationViewHolder::class.java,
    entitiesSource = entitiesSource
)
