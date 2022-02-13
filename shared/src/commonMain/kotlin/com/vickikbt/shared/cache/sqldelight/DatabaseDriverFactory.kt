package com.vickikbt.shared.cache.sqldelight

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver():SqlDriver
}
