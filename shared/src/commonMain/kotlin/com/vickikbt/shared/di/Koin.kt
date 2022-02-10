package com.vickikbt.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModules)
}

/**
 * Called by iOS etc
 */
fun initKoin() = initKoin {}