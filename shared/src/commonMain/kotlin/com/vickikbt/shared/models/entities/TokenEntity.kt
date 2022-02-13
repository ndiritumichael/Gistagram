package com.vickikbt.shared.models.entities

data class TokenEntity(
    var accessToken: String? = null,

    var scope: String? = null,

    var tokenType: String? = null
)
