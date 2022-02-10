package com.vickikbt.shared.network.rest

import com.vickikbt.shared.models.dtos.TokenDto

interface ApiClient {

    suspend fun getUserToken(clientId:String, clientSecret:String,code:String):TokenDto?

}