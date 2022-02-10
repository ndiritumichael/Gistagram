package com.vickikbt.gistagram.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.gistagram.utils.Constants
import com.vickikbt.shared.repositories.auth_repository.AuthRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthViewModel constructor(private val authRepository: AuthRepository) : ViewModel() {

    fun getUserToken(code: String) {
        viewModelScope.launch {
            val response = authRepository.getUserToken(
                clientId = Constants.CLIENT_ID,
                clientSecret = Constants.CLIENT_SECRET,
                code = code
            )
            Timber.e("Response: $response")
        }
    }

}