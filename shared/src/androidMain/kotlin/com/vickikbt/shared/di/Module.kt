package com.vickikbt.shared.di

import com.vickikbt.shared.cache.sqldelight.DatabaseDriverFactory
import org.koin.dsl.module

val androidMainModule = module {
    single { DatabaseDriverFactory(context = get()) }
}