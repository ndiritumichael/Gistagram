package com.vickikbt.shared.data.mappers

import com.vickikbt.shared.domain.models.Token
import com.vickikbt.shared.data.models.entities.TokenEntity

internal fun TokenEntity.toDomain(): Token {
    return Token(
        accessToken = this.accessToken,
        scope = this.scope,
        tokenType = this.tokenType
    )
}