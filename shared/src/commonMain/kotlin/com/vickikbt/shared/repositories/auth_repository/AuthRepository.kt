package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto
import com.vickikbt.shared.models.entities.TokenEntity

interface AuthRepository {

    suspend fun getUserToken(clientId:String, clientSecret:String, code:String):TokenDto?

    //suspend fun saveUserToken(tokenEntity: TokenEntity)

}