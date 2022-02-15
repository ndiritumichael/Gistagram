package com.vickikbt.shared.data.network.graphql

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import com.vickikbt.shared.data.cache.realm.TokenDao
import de.jensklingenberg.cabret.Cabret
import de.jensklingenberg.cabret.DebugLog
import io.realm.internal.platform.runBlocking
import kotlinx.coroutines.flow.first

class AuthorizationInterceptor constructor(private val tokenDao: TokenDao) : HttpInterceptor {

    val token: String? = runBlocking { tokenDao.getToken.first() }

    @DebugLog(tag = "VickiKbt", logLevel = Cabret.LogLevel.ERROR)
    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain
    ): HttpResponse {
        return chain.proceed(
            request.newBuilder().addHeader("Authorization", "Bearer: $token").build()
        )
    }

}