package com.pmt.ui.login

import com.pmt.network.AuthApiService
import com.pmt.network.apiRequestFlow
import com.pmt.network.dto.Auth
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val authApiService: AuthApiService,
) {
    fun login(auth: Auth) = apiRequestFlow {
        authApiService.login(auth)
    }
}