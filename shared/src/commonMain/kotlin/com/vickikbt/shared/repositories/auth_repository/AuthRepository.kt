package com.vickikbt.shared.repositories.auth_repository

import com.vickikbt.shared.models.dtos.TokenDto

interface AuthRepository {

    suspend fun getUserToken(clientId:String, clientSecret:String, code:String):TokenDto?

}