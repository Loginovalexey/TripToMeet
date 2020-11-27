package ru.triptomeet.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.screen_splash.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.signinscreen.SignInScreenFragment

class SplashScreenFragment : Fragment() {

    private val splashViewModel: SplashViewModel by viewModel()

    private lateinit var backgroundTransitionGenerator: BackgroundTransitionGenerator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.screen_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val observer = Observer<SplashViewState> { renderData(it) }

        splashViewModel.showPresentation().observe(viewLifecycleOwner, observer)

        backgroundTransitionGenerator = BackgroundTransitionGenerator()

        backgroundTransitionGenerator.setMinRectFactor(0.9f)


        splashBeginButton.setOnClickListener {
            (activity as IOnCallChangeScreen).replaceFragment(
                SignInScreenFragment()
            )
        }
    }

    private fun renderData(state: SplashViewState) {
        kenBurnsImageView.setImageResource(state.imageInt)
        titleSplashText.text = state.title
        bodySplashText.text = state.body
        kenBurnsImageView.setTransitionGenerator(backgroundTransitionGenerator)
    }

}

