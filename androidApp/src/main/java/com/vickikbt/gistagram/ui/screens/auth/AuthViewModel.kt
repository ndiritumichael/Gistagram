package com.vickikbt.gistagram.ui.screens.auth

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.gistagram.utils.Constants
import com.vickikbt.shared.data.repositories.auth_repository.AuthRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthViewModel constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _userToken: MutableState<String?> = mutableStateOf(null)
    val userToken: State<String?> get() = _userToken

    fun fetchUserToken(code: String) {
        viewModelScope.launch {
            authRepository.getUserToken(
                clientId = Constants.CLIENT_ID,
                clientSecret = Constants.CLIENT_SECRET,
                code = code
            )
        }
    }

    fun getToken() {
        viewModelScope.launch {
            _userToken.value = authRepository.getToken().first()
        }
    }

}