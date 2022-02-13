package com.vickikbt.shared.models.domain

data class Token(
    val accessToken: String? = null,
    val scope: String? = null,
    val tokenType: String? = null
)
