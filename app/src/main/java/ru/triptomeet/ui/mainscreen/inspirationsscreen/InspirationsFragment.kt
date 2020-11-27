package ru.triptomeet.ui.mainscreen.inspirationsscreen

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.screen_inspirations.*
import ru.triptomeet.R
import ru.triptomeet.model.entity.InspirationForList
import ru.triptomeet.ui.MainActivity
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Список "Вдохновений"
 */

class InspirationsFragment : StaticBaseFragment<InspirationForList>(
    itemId = R.layout.item_inspiration,
    fragmentId = R.layout.screen_inspirations,
    containerId = R.id.inspirationsRecycler,
    viewHolderType = InspirationViewHolder::class.java,
    entitiesSource = InspirationsMockDataSource()
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //При нажатии на стрелку назад на панели инструментов - возвращение на домашний экран
        inspirationsToolbar.setNavigationOnClickListener {
            (requireActivity() as MainActivity)
                .onBackPressed()
        }
    }
}