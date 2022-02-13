package com.vickikbt.shared.cache.sqldelight

import com.squareup.sqldelight.db.SqlDriver
import com.vickikbt.shared.sqldelight.AppDatabase

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

internal fun createDatabase(driverFactory: DatabaseDriverFactory): AppDatabase {
    val driver = driverFactory.createDriver()
    return AppDatabase(driver)
}
