package ru.triptomeet.ui.mainscreen.home.locals

import ru.triptomeet.R
import ru.triptomeet.model.entity.Local
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Фрагмент-список "Местные жители" на "домашнем" экране (Home)
 */

class LocalsFragment(entitiesSource: IDataSource) : StaticBaseFragment<Local>(
    itemId = R.layout.item_local,
    containerId = R.id.reviewsList,
    fragmentId = R.layout.layer_main_locals,
    viewHolderType = LocalViewHolder::class.java,
    entitiesSource = entitiesSource
)