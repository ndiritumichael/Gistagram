package com.vickikbt.shared.sqldelight

import kotlin.String

data class TokenEntity(
  val accessToken: String,
  val scope: String?,
  val tokenType: String?
) {
  override fun toString(): String = """
  |TokenEntity [
  |  accessToken: $accessToken
  |  scope: $scope
  |  tokenType: $tokenType
  |]
  """.trimMargin()
}
