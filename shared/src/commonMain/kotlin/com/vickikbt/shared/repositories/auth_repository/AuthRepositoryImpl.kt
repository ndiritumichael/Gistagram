package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto
import com.vickikbt.shared.network.rest.ApiClient

class AuthRepositoryImpl constructor(private val apiClient: ApiClient) : AuthRepository {

    override suspend fun getUserToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): TokenDto? {
        return apiClient.getUserToken(clientId = clientId, clientSecret = clientSecret, code = code)
    }

}