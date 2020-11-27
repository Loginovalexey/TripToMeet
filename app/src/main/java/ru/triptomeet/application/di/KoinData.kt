package ru.triptomeet.application.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.triptomeet.application.retrofit.ApiClient
import ru.triptomeet.model.Model
import ru.triptomeet.ui.mainscreen.home.HomeViewModel
import ru.triptomeet.ui.mainscreen.home.foryou.ForYouViewModel
import ru.triptomeet.ui.mainscreen.home.popular.PopularViewModel
import ru.triptomeet.ui.mainscreen.impressionscreen.ImpressionViewModel
import ru.triptomeet.ui.questionsscreen.ClickQuestionsViewModel
import ru.triptomeet.ui.searchlocation.SearchLocationViewModel
import ru.triptomeet.ui.signinscreen.SignInViewModel
import ru.triptomeet.ui.splashscreen.SplashViewModel

//Объекты, внедряемые с помощью библиотеки Koin

val appModule = module {
    single { Model() }
}

val networkModule = module {
    single { ApiClient() }
}

val viewModelsModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { SignInViewModel() }
    viewModel { ClickQuestionsViewModel() }
    viewModel { ForYouViewModel() }
    viewModel { PopularViewModel() }
    viewModel { ImpressionViewModel() }
    viewModel { SearchLocationViewModel() }
    viewModel { HomeViewModel() }

}