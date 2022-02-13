package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto
import com.vickikbt.shared.network.rest.ApiClient

class AuthRepositoryImpl constructor(
    private val apiClient: ApiClient
) : AuthRepository {

    override suspend fun getUserToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): TokenDto? {
        val response =
            apiClient.getUserToken(clientId = clientId, clientSecret = clientSecret, code = code)

        /*response?.let {
            saveUserToken(tokenEntity = it.toEntity())
        }*/

        return response
    }

    /*override suspend fun saveUserToken(tokenEntity: TokenEntity) {
        println("Saving user token: $tokenEntity")
        return realmDao.saveUserToken(tokenEntity = tokenEntity)
    }*/

}