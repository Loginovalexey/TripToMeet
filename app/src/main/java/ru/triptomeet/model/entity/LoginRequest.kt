package ru.triptomeet.model.entity

import com.google.gson.annotations.SerializedName

/**
 * Класс учетной записи
 */

data class LoginRequest(

    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String

)