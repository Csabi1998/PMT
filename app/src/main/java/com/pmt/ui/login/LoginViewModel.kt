package com.pmt.ui.login

import androidx.lifecycle.MutableLiveData
import com.pmt.network.BaseViewModel
import com.pmt.network.CoroutinesErrorHandler
import com.pmt.network.dto.Auth
import com.pmt.network.response.ApiResponse
import com.pmt.network.response.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
): BaseViewModel() {

    private val _loginResponse = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginResponse = _loginResponse

    fun login(auth: Auth, coroutinesErrorHandler: CoroutinesErrorHandler) = baseRequest(
        _loginResponse,
        coroutinesErrorHandler
    ) {
        loginRepository.login(auth)
    }
}