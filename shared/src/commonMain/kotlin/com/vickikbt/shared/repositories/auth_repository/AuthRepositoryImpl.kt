package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto
import com.vickikbt.shared.network.rest.ApiClient
import com.vickikbt.shared.sqldelight.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class AuthRepositoryImpl constructor(
    private val apiClient: ApiClient,
    private val appDatabase: AppDatabase
) : AuthRepository {

    private val tokenEntityQueries = appDatabase.tokenEntityQueries

    override suspend fun getUserToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): TokenDto? {
        val response =
            apiClient.getUserToken(clientId = clientId, clientSecret = clientSecret, code = code)

        response?.let {
            saveToken(
                accessToken = response.accessToken,
                scope = response.scope,
                tokenType = response.tokenType
            )
        }

        return response
    }

    override suspend fun getToken(): Flow<String?> {
        return withContext(Dispatchers.Default) {
            flowOf(tokenEntityQueries.getToken().executeAsOneOrNull())
        }
    }

    override suspend fun saveToken(accessToken: String, scope: String, tokenType: String) {
        withContext(Dispatchers.Default) {
            tokenEntityQueries.saveToken(
                accessToken = accessToken,
                scope = scope,
                tokenType = tokenType
            )
        }
    }

    override suspend fun deleteToken() {
        withContext(Dispatchers.Default) {
            tokenEntityQueries.deleteToken()
        }
    }

}