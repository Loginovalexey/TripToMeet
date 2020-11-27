package ru.triptomeet.ui.signinscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.triptomeet.application.Constants
import ru.triptomeet.application.retrofit.ApiClient
import ru.triptomeet.model.Model
import ru.triptomeet.model.entity.LoginRequest
import ru.triptomeet.model.entity.LoginResponse
import ru.triptomeet.utils.toLog


class SignInViewModel : ViewModel(), KoinComponent {

    private val model: Model by inject()
    private val apiClient: ApiClient by inject()

    var signInPermission: MutableLiveData<SignInPermissionState> = MutableLiveData()

    fun serverRequest() {
        apiClient
            .apiService
            .login(LoginRequest(password = "11111", username = "Bob"))
            .enqueue(object :
                Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    toLog("onFailure")
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()
                    if (loginResponse != null && response.code() == Constants.CODE_OK) {
                        allowEntry(loginResponse.authToken)

                    } else {
                        toLog("error")
                    }
                }
            })
    }

    fun allowEntry(authToken: String) {
        model.authToken=authToken
        signInPermission.value = SignInPermissionState.ALLOWED
    }

}