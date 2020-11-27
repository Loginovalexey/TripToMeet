package ru.triptomeet.model.entity

import com.google.gson.annotations.SerializedName

/**
 * Класс ответа от сервера с токеном
 */

data class LoginResponse (

    @SerializedName("token")
    var authToken: String
)