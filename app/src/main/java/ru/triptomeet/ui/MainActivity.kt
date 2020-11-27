package ru.triptomeet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ru.triptomeet.R
import ru.triptomeet.ui.splashscreen.SplashScreenFragment

class MainActivity : AppCompatActivity(), IOnCallChangeScreen {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.NoActionBar)
        setContentView(R.layout.activity_main)
        replaceFragment(SplashScreenFragment())
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootActivityLayout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    override fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootActivityLayout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack("MainActivity")
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.last() is IOnBackPressed)
            (supportFragmentManager.fragments.last() as IOnBackPressed).pressBack()
        else
            super.onBackPressed()
    }
}
