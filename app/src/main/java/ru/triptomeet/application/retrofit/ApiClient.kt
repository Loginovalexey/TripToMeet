package ru.triptomeet.application.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.triptomeet.application.Constants.BASE_URL

/**
 * Класс для работы с Rest API веб-сервера
 */

class ApiClient {


    //Перехватчик данных для логирования
    var httpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val tripToMeetClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(tripToMeetClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}


