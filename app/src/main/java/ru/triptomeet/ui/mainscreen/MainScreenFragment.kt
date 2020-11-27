package ru.triptomeet.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.paging.ExperimentalPagingApi
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.screen_main.*
import ru.triptomeet.R
import ru.triptomeet.ui.IOnBackPressed
import ru.triptomeet.ui.MainActivity
import ru.triptomeet.ui.mainscreen.home.HomeFragment
import ru.triptomeet.ui.mainscreen.inspirationsscreen.InspirationsFragment
import ru.triptomeet.ui.mainscreen.offersscreen.OffersScreenFragment
import ru.triptomeet.ui.questionsscreen.QuestionsScreenFragment

/**
 * Главный фрагмент с нижней навигационной панелью
 */

class MainScreenFragment : Fragment(),
    IOnBackPressed,
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.screen_main, container, false)


    @ExperimentalPagingApi
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBottomNavigation()
        replaceFragmentInMainFrame(HomeFragment())
    }


    @ExperimentalPagingApi
    private fun initBottomNavigation() {
        mainBottomNavigation.setOnNavigationItemSelectedListener(
            this::onNavigationItemSelected
        )
    }

    //Обработка нажатий на нижней навигационной панели с отклонением повторного нажатия
    @ExperimentalPagingApi
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionHome -> if (childFragmentManager.fragments.last() !is HomeFragment)
                replaceFragmentInMainFrame(HomeFragment())
            R.id.actionLamp -> if (childFragmentManager.fragments.last()
                        !is InspirationsFragment
            )
                replaceFragmentInMainFrame(InspirationsFragment())
            R.id.actionPerson -> if (childFragmentManager.fragments.last() !is OffersScreenFragment)
                replaceFragmentInMainFrame(OffersScreenFragment())
        }
        return true
    }

    private fun replaceFragmentInMainFrame(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    override fun pressBack() {
        //При нажатии на кнопку назад - переход на "домашний экран"
        if (childFragmentManager.fragments.last() !is HomeFragment) {
            mainBottomNavigation.menu.findItem(R.id.actionHome).isChecked = true
            replaceFragmentInMainFrame(HomeFragment())
        } else
        //Если кнопка "Назад" нажата на домашнем экране, переход на экран выбора интересов
            (requireActivity() as MainActivity).replaceFragment(QuestionsScreenFragment())
    }
}