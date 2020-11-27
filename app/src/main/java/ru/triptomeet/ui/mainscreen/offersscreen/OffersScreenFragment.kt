package ru.triptomeet.ui.mainscreen.offersscreen

import android.os.Bundle
import android.view.View
import androidx.paging.ExperimentalPagingApi
import kotlinx.android.synthetic.main.screen_offers.*
import ru.triptomeet.R
import ru.triptomeet.model.entity.Offer
import ru.triptomeet.ui.MainActivity
import ru.triptomeet.ui.base.fragment.PagingBaseFragment


@ExperimentalPagingApi

/**
 * Реалиазация экрана "Мои предложения"
 */

class OffersScreenFragment : PagingBaseFragment<Offer>(
    fragmentId = R.layout.screen_offers,
    containerId = R.id.offersRecyclerView,
    itemId = R.layout.item_offer,
    entitiesSource = OffersPagingDataSource(),
    viewHolderType = OfferScreenViewHolder::class.java
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //При нажатии на стрелку назад на панели инструментов - возвращение на домашний экран
        offersToolbar.setNavigationOnClickListener {
            (requireActivity() as MainActivity)
                .onBackPressed()
        }
    }
}