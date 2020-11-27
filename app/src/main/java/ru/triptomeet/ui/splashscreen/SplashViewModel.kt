package ru.triptomeet.ui.splashscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.triptomeet.application.Constants.SPLASH_EPISODE_DURATION

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val states = initSplash(application)

    fun showPresentation(): LiveData<SplashViewState> {
        val splashLiveData = MutableLiveData<SplashViewState>()
        GlobalScope.launch (Dispatchers.Main) {
            states[0].let { splashLiveData.value = it }
            var i = 1
            while (true) {
                delay(SPLASH_EPISODE_DURATION.toLong())
                splashLiveData.value = states[i]
                i++
                i %= states.size
            }
        }
        return splashLiveData
    }
}
