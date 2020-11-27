package ru.triptomeet.ui.splashscreen

import android.content.Context
import ru.triptomeet.R

fun initSplash(context: Context):List<SplashViewState> {
    val resources = context.resources
    return arrayListOf(
        SplashViewState(
            R.drawable.daniel_jensen_unsplash_1,
            resources.getString(R.string.titleSplash1), resources.getString(R.string.bodySplash1)
        ),
        SplashViewState(
            R.drawable.simon_rae_unsplash_1,
            resources.getString(R.string.titleSplash2), resources.getString(R.string.bodySplash2)
        ),
        SplashViewState(
            R.drawable.tyler_nix_q_nsplash_1,
            resources.getString(R.string.titleSplash3), resources.getString(R.string.bodySplash3)
        )
    )
}