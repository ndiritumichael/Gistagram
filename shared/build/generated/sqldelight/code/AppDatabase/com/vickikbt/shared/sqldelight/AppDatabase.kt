package com.vickikbt.shared.sqldelight

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import com.vickikbt.shared.sqldelight.shared.newInstance
import com.vickikbt.shared.sqldelight.shared.schema

interface AppDatabase : Transacter {
  val tokenEntityQueries: TokenEntityQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = AppDatabase::class.schema

    operator fun invoke(driver: SqlDriver): AppDatabase = AppDatabase::class.newInstance(driver)}
}
