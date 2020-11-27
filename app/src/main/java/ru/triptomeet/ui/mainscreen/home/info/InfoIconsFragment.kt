package ru.triptomeet.ui.mainscreen.home.info

import ru.triptomeet.R
import ru.triptomeet.model.entity.Info
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Фрагмент-список информационных иконок на "домашнем" экране (Home)
 */

class InfoIconsFragment : StaticBaseFragment<Info>(
    fragmentId = R.layout.layer_main_info,
    containerId = R.id.infoRecycler,
    itemId = R.layout.item_info,
    viewHolderType = InfoIconViewHolder::class.java,
    entitiesSource = InfoIconsMockDataSource()
)