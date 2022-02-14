package com.vickikbt.shared.data.repositories.auth_repository

import com.vickikbt.shared.data.cache.realm.TokenDao
import com.vickikbt.shared.data.mappers.toDomain
import com.vickikbt.shared.data.mappers.toEntity
import com.vickikbt.shared.data.models.dtos.TokenDto
import com.vickikbt.shared.data.models.entities.TokenEntity
import com.vickikbt.shared.data.network.rest.ApiClient
import de.jensklingenberg.cabret.Cabret
import de.jensklingenberg.cabret.DebugLog

class AuthRepositoryImpl constructor(
    private val apiClient: ApiClient,
    private val tokenDao: TokenDao
) : AuthRepository {

    @DebugLog(tag = "VickiKbt", logLevel = Cabret.LogLevel.ERROR)
    override suspend fun getUserToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): TokenDto? {
        val response =
            apiClient.getUserToken(clientId = clientId, clientSecret = clientSecret, code = code)

        response?.let { saveToken(it.toEntity()) }

        return response
    }

    override suspend fun getToken() = tokenDao.getToken

    @DebugLog(tag = "VickiKbt", logLevel = Cabret.LogLevel.ERROR)
    override suspend fun saveToken(tokenEntity: TokenEntity) =
        tokenDao.saveToken(tokenEntity = tokenEntity)

    override suspend fun deleteToken() = tokenDao.deleteToken()

}