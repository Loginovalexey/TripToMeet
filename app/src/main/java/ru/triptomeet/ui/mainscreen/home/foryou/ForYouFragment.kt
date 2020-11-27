package ru.triptomeet.ui.mainscreen.home.foryou

import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.model.entity.ForYou
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListenerForView
import ru.triptomeet.ui.mainscreen.impressionscreen.ImpressionFragment

/**
 * Фрагмент-список "Для тебя" на "домашнем" экране (Home)
 */

class ForYouFragment(entitiesSource: IDataSource) : StaticBaseFragment<ForYou>(
    itemId = R.layout.item_for_you,
    fragmentId = R.layout.layer_main_for_you,
    containerId = R.id.forYouRecycler,
    viewHolderType = ForYouViewHolder::class.java,
    entitiesSource = entitiesSource
), IOnItemClickListenerForView<ForYou>{

    private val forYouViewModel: ForYouViewModel by viewModel()

    // При выборе элемента списка - сохранение идентификатора выбранного элемента и подробное
    // отображение его данных на экране "Впечатление" (Impression)
    override fun onItemClick(item: ForYou, view: View) {
        forYouViewModel.saveForYou(item)
        (activity as IOnCallChangeScreen).addFragment(ImpressionFragment())
    }
}
