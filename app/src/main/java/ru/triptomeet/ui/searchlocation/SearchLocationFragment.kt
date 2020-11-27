package ru.triptomeet.ui.searchlocation


import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.screen_search_location.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.model.entity.InspirationForGallery
import ru.triptomeet.model.entity.SearchLocation
import ru.triptomeet.ui.MainActivity
import ru.triptomeet.ui.base.fragment.StaticBaseFragment
import ru.triptomeet.ui.mainscreen.home.inspirations.InspirationsFragment
import ru.triptomeet.ui.mainscreen.home.inspirations.InspirationsMockDataSource


class SearchLocationFragment(private val inspiration: List<InspirationForGallery>?) :
    StaticBaseFragment<SearchLocation>(
        itemId = R.layout.item_search_location,
        fragmentId = R.layout.screen_search_location,
        containerId = R.id.searchLocationHistoryList,
        viewHolderType = SearchLocationViewHolder::class.java,
        entitiesSource = SearchLocationDataSource()
    ) {

    private val searchLocationViewModel: SearchLocationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createInspirations()
        initClickListeners()
    }

    private fun createInspirations() {
        inspiration?.let {
            val fragmentTransaction = childFragmentManager
                .beginTransaction()
            fragmentTransaction.add(
                R.id.inspirationsLayer,
                InspirationsFragment(InspirationsMockDataSource(inspiration))
            )
            fragmentTransaction.commit()
        }
    }


    private fun initClickListeners() {

        //При нажатии на стрелку назад на панели инструментов - возвращение на домашний экран
        searchLocationToolbar.setNavigationOnClickListener {
            (requireActivity() as MainActivity)
                .onBackPressed()
        }

        searchLocationEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                searchLocationEditText.text?.let {
                    if (it.isNotEmpty()) {
                        searchLocationViewModel.saveSearchLocation(it.toString().trim())
                        activity?.onBackPressed()
                    }
                }
            }
            true
        }
    }
}




