package ru.triptomeet.application

import android.app.Application
import ru.triptomeet.application.di.appModule
import com.squareup.leakcanary.LeakCanary
import ru.triptomeet.application.di.networkModule
import org.koin.android.ext.android.startKoin
import ru.triptomeet.application.di.viewModelsModule


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //Инициализация внедрения объектов
        startKoin(
            this,
            listOf(appModule, networkModule, viewModelsModule)
        )

        //Подключение библиотеки LeakCanary для отслеживания утечек памяти
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }
}
