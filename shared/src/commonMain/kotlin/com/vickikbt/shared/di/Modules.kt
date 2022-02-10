package com.vickikbt.shared.di

import com.vickikbt.shared.network.rest.ApiClient
import com.vickikbt.shared.network.rest.ApiClientImpl
import com.vickikbt.shared.repositories.auth_repository.AuthRepository
import com.vickikbt.shared.repositories.auth_repository.AuthRepositoryImpl
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module

val commonModules = module {

    single {
        HttpClient {
            install(Logging) { level = LogLevel.ALL }
            install(JsonFeature) { serializer = KotlinxSerializer() }
        }
    }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    single<ApiClient> { ApiClientImpl(get()) }
}