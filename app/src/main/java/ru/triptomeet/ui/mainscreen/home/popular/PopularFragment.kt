package ru.triptomeet.ui.mainscreen.home.popular

import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.model.entity.Popular
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListenerForView
import ru.triptomeet.ui.mainscreen.impressionscreen.ImpressionFragment

/**
 * Фрагмент-список "Популярное" на "домашнем" экране (Home)
 */

class PopularFragment(entitiesSource: IDataSource)  : StaticBaseFragment<Popular>(
    itemId = R.layout.item_popular,
    containerId = R.id.popularRecycler,
    fragmentId = R.layout.layer_main_popular,
    viewHolderType = PopularViewHolder::class.java,
    entitiesSource = entitiesSource
), IOnItemClickListenerForView<Popular> {

    private val popularViewModel: PopularViewModel by viewModel()

    // При выборе элемента списка - сохранение идентификатора выбранного элемента и подробное
    // отображение его данных на экране "Впечатление" (Impression)
    override fun onItemClick(item: Popular, view: View) {
        popularViewModel.savePopular(item)
        (activity as IOnCallChangeScreen).addFragment(ImpressionFragment())
    }
}
