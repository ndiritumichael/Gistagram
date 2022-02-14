package com.vickikbt.gistagram.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.gistagram.utils.Constants
import com.vickikbt.shared.data.repositories.auth_repository.AuthRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthViewModel constructor(private val authRepository: AuthRepository) : ViewModel() {

    init {
        //getToken()
    }

    fun getUserToken(code: String) {
        viewModelScope.launch {
            val response = authRepository.getUserToken(
                clientId = Constants.CLIENT_ID,
                clientSecret = Constants.CLIENT_SECRET,
                code = code
            )
        }
    }

    fun getToken() {
        viewModelScope.launch {
            val response = authRepository.getToken().first()
            Timber.e("Token saved: $response")
        }
    }

}