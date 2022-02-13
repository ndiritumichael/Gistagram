package com.vickikbt.shared.mappers

import com.vickikbt.shared.models.domain.Token
import com.vickikbt.shared.models.entities.TokenEntity

internal fun TokenEntity.toDomain(): Token {
    return Token(
        accessToken = this.accessToken,
        scope = this.scope,
        tokenType = this.tokenType
    )
}