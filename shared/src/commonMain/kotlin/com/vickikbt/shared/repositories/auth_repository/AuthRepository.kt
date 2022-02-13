package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    /**
     * Makes an API call to GitHub REST API to get user token
     */
    suspend fun getUserToken(clientId: String, clientSecret: String, code: String): TokenDto?

    /**
     * Retrieves token saved in sqlDelight
     */
    suspend fun getToken(): Flow<String?>

    /**
     * Saves a new token in sqlDelight
     */
    suspend fun saveToken(accessToken: String, scope: String, tokenType: String)

    /**
     * Deletes token saved in sqlDelight
     */
    suspend fun deleteToken()

}