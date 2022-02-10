package com.vickikbt.shared.models.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    val access_token: String,
    val scope: String,
    val token_type: String
)