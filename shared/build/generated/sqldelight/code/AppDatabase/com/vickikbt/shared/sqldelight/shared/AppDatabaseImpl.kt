package com.vickikbt.shared.sqldelight.shared

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import com.vickikbt.shared.sqldelight.AppDatabase
import com.vickikbt.shared.sqldelight.TokenEntityQueries
import kotlin.Int
import kotlin.String
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<AppDatabase>.schema: SqlDriver.Schema
  get() = AppDatabaseImpl.Schema

internal fun KClass<AppDatabase>.newInstance(driver: SqlDriver): AppDatabase =
    AppDatabaseImpl(driver)

private class AppDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), AppDatabase {
  override val tokenEntityQueries: TokenEntityQueriesImpl = TokenEntityQueriesImpl(this, driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE TokenEntity(
          |accessToken TEXT DEFAULT NULL PRIMARY KEY ,
          |scope TEXT DEFAULT NULL,
          |tokenType TEXT DEFAULT NULL
          |)
          """.trimMargin(), 0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class TokenEntityQueriesImpl(
  private val database: AppDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), TokenEntityQueries {
  internal val getToken: MutableList<Query<*>> = copyOnWriteList()

  override fun getToken(): Query<String> = Query(1768241553, getToken, driver, "TokenEntity.sq",
      "getToken", """
  |SELECT ALL accessToken
  |FROM TokenEntity
  |WHERE accessToken IS NOT NULL
  """.trimMargin()) { cursor ->
    cursor.getString(0)!!
  }

  override fun saveToken(
    accessToken: String,
    scope: String?,
    tokenType: String?
  ) {
    driver.execute(-1673085202, """
    |INSERT OR REPLACE
    |INTO TokenEntity
    |VALUES (?,?,?)
    """.trimMargin(), 3) {
      bindString(1, accessToken)
      bindString(2, scope)
      bindString(3, tokenType)
    }
    notifyQueries(-1673085202, {database.tokenEntityQueries.getToken})
  }

  override fun deleteToken() {
    driver.execute(2099057408, """DELETE FROM TokenEntity""", 0)
    notifyQueries(2099057408, {database.tokenEntityQueries.getToken})
  }
}
