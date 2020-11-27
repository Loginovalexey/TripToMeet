package ru.triptomeet.application.retrofit

import retrofit2.Call
import retrofit2.http.*
import ru.triptomeet.application.Constants
import ru.triptomeet.model.entity.LoginRequest
import ru.triptomeet.model.entity.LoginResponse
import ru.triptomeet.model.entity.Offer

interface ApiService {

    /**
     * Получение токена
     */
    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    /**
     * Получение списка заказов(с пагинацией)
     */
    @GET("api/v1/adverts/user_id={user_id}")
    suspend fun getOffer(
        @Header("Authorization") token: String,
        @Path("user_id") userId: Int,
        @Query("page_number") pageNumber: Int,
        @Query("page_size") pageSize: Int
    ): List<Offer>

    //Получение списка всех заказов без пагинации
    @GET(Constants.ADVERTS_URL)
    suspend fun getAdvertsList(@Header("Authorization") token: String): List<Offer>
}