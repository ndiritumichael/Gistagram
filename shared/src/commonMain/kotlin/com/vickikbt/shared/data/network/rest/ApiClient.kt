package com.vickikbt.shared.data.network.rest

import com.vickikbt.shared.data.models.dtos.TokenDto

interface ApiClient {

    suspend fun getUserToken(clientId:String, clientSecret:String,code:String):TokenDto?

}