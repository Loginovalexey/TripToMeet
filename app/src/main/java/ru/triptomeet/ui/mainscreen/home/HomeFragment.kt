package ru.triptomeet.ui.mainscreen.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import kotlinx.android.synthetic.main.screen_home.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.model.entity.Home
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.base.DataResult
import ru.triptomeet.ui.mainscreen.home.foryou.ForYouFragment
import ru.triptomeet.ui.mainscreen.home.foryou.ForYouMockDataSource
import ru.triptomeet.ui.mainscreen.home.inspirations.InspirationsFragment
import ru.triptomeet.ui.mainscreen.home.inspirations.InspirationsMockDataSource
import ru.triptomeet.ui.mainscreen.home.locals.LocalsFragment
import ru.triptomeet.ui.mainscreen.home.locals.LocalsMockDataSource
import ru.triptomeet.ui.mainscreen.home.popular.PopularFragment
import ru.triptomeet.ui.mainscreen.home.popular.PopularMockDataSource
import ru.triptomeet.ui.searchlocation.SearchLocationFragment

/**
 * "Домашний" экрана (кнопка Home)
 */

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.screen_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    //Ожидание получения данных
    private fun observe() {
        lifecycleScope.launch {
            homeViewModel.fetch()
                .distinctUntilChanged()
                .collectLatest { processResult(it) }
        }
    }

    //Действия при получении данных
    @SuppressLint("UseCompatLoadingForDrawables", "SimpleDateFormat")
    private fun processResult(result: DataResult) {
        when (result) {
            is DataResult.SuccessAny<*> ->
                (result.data as Home).also {
                    createTop(it)
                    createForYou(it)
                    createInspiration(it)
                    createPopular(it)
                    createLocals(it)
                }
            is DataResult.Error ->{

            }
        }
    }

    //Показ верхнего изображения и титра
    private fun createTop(home: Home) {
        fun initClickListeners() {
            //В экране поиска есть слой "Вдохновение". Данные для него передаются в качестве
            //аргумента при создании фрагмента
            homeTopSearchImage.setOnClickListener {
                (activity as IOnCallChangeScreen).addFragment(SearchLocationFragment(home.inspirations))
            }

            homeTopTitle.setOnClickListener {
                (activity as IOnCallChangeScreen).addFragment(SearchLocationFragment(home.inspirations))
            }

            homeTopLocationIcon.setOnClickListener {
                (activity as IOnCallChangeScreen).addFragment(SearchLocationFragment(home.inspirations))
            }
        }
        home.also {
            homeTopImage.load(it.imageId)
            homeTopTitle.text = it.title
        }
        initClickListeners()
    }

    private fun createForYou(home: Home) {
        home.forYou?.let {
            placeFragment(ForYouFragment(ForYouMockDataSource(it)), R.id.forYouLayer)
        }
    }


    private fun createInspiration(home: Home) {
        home.inspirations?.let {
            placeFragment(
                InspirationsFragment(InspirationsMockDataSource(it)),
                R.id.inspirationsLayer
            )
        }
    }

    private fun createPopular(home: Home) {
        home.popular?.let {
            placeFragment(
                PopularFragment(PopularMockDataSource(it)),
                R.id.popularLayer
            )
        }
    }

    private fun createLocals(home: Home) =
        home.locals?.let {
            placeFragment(
                LocalsFragment(LocalsMockDataSource(it)),
                R.id.localsLayer
            )
        }

    private fun placeFragment(fragment: Fragment, containerId: Int): Int {
        val fragmentTransaction = childFragmentManager
            .beginTransaction()
        fragmentTransaction.add(containerId, fragment)
        return fragmentTransaction.commit()
    }


}