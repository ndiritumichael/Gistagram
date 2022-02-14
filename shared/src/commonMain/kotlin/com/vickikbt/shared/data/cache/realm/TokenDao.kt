package com.vickikbt.shared.data.cache.realm

import com.vickikbt.shared.data.models.entities.TokenEntity
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class TokenDao constructor(private val appDatabase: Realm) {

    fun saveToken(tokenEntity: TokenEntity) {
        CoroutineScope(context = Dispatchers.Default).launch {
            appDatabase.write {
                copyToRealm(tokenEntity)
            }
        }
    }

    val getToken = flowOf(appDatabase.objects(TokenEntity::class).query().first().accessToken)

    fun deleteToken() = appDatabase.objects(TokenEntity::class).delete()


}