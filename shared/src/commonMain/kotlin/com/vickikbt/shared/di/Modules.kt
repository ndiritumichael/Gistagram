package com.vickikbt.shared.di

import com.vickikbt.shared.cache.sqldelight.DatabaseDriverFactory
import com.vickikbt.shared.cache.sqldelight.createDatabase
import com.vickikbt.shared.network.rest.ApiClient
import com.vickikbt.shared.network.rest.ApiClientImpl
import com.vickikbt.shared.repositories.auth_repository.AuthRepository
import com.vickikbt.shared.repositories.auth_repository.AuthRepositoryImpl
import com.vickikbt.shared.sqldelight.AppDatabase
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module

val commonModules = module {

    /**
     * Creates a http client for Ktor
     */
    single {
        HttpClient {
            install(Logging) { level = LogLevel.ALL }
            install(JsonFeature) { serializer = KotlinxSerializer() }
        }
    }

    /**
     *
     */

    //ToDo: Provide instance of sqlDelight. For all platforms?
    /*single {
        createDatabase(driverFactory = DatabaseDriverFactory)
    }*/

    single<AuthRepository> { AuthRepositoryImpl(apiClient = get(), appDatabase = get()) }

    single<ApiClient> { ApiClientImpl(httpClient = get()) }
}

/*
private fun provideSqlDriver(app:ContentType.Application){
    return
}*/
