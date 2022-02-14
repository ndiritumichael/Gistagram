package com.vickikbt.shared.data.mappers

import com.vickikbt.shared.data.models.dtos.TokenDto
import com.vickikbt.shared.data.models.entities.TokenEntity

internal fun TokenDto.toEntity(): TokenEntity {
    return TokenEntity().apply {
        this.accessToken = this@toEntity.accessToken
        this.scope = this@toEntity.scope
        this.tokenType = this@toEntity.tokenType
    }
}