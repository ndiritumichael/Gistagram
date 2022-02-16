package com.vickikbt.shared.data.repositories.auth_repository

import com.vickikbt.shared.data.models.dtos.TokenDto
import com.vickikbt.shared.data.models.entities.TokenEntity
import io.realm.RealmResults
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    /**
     * Makes an API call to GitHub REST API to get user token
     */
    suspend fun getUserToken(clientId: String, clientSecret: String, code: String): TokenDto?

    /**
     * Retrieves token saved in sqlDelight
     */
    suspend fun getToken(): Flow<RealmResults<TokenEntity>>

    /**
     * Saves a new token in sqlDelight
     */
    suspend fun saveToken(tokenEntity: TokenEntity)

    /**
     * Deletes token saved in sqlDelight
     */
    suspend fun deleteToken()
}
