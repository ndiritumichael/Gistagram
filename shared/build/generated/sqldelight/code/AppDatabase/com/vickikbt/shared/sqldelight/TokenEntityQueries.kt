package com.vickikbt.shared.sqldelight

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.String
import kotlin.Unit

public interface TokenEntityQueries : Transacter {
  public fun getToken(): Query<String>

  public fun saveToken(
    accessToken: String,
    scope: String?,
    tokenType: String?
  ): Unit

  public fun deleteToken(): Unit
}
