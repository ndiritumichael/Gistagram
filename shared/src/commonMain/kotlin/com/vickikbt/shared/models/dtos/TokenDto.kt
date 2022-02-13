package com.vickikbt.shared.models.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    @SerialName("access_token")
    val accessToken: String,

    @SerialName("scope")
    val scope: String,

    @SerialName("token_type")
    val tokenType: String
)