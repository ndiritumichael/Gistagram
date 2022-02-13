package com.vickikbt.shared.sqldelight

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import com.vickikbt.shared.sqldelight.shared.newInstance
import com.vickikbt.shared.sqldelight.shared.schema

public interface AppDatabase : Transacter {
  public val tokenEntityQueries: TokenEntityQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = AppDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): AppDatabase =
        AppDatabase::class.newInstance(driver)
  }
}
