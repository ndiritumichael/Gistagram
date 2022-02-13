package com.vickikbt.shared.sqldelight

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.String

interface TokenEntityQueries : Transacter {
  fun getToken(): Query<String>

  fun saveToken(
    accessToken: String,
    scope: String?,
    tokenType: String?
  )

  fun deleteToken()
}
