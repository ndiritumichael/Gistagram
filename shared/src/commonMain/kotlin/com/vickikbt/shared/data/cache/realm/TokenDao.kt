package com.vickikbt.shared.data.cache.realm

import com.vickikbt.shared.data.models.entities.TokenEntity
import io.realm.Realm
import io.realm.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TokenDao constructor(private val appDatabase: Realm) {

    fun saveToken(tokenEntity: TokenEntity) {
        CoroutineScope(context = Dispatchers.Default).launch {
            appDatabase.write {
                copyToRealm(tokenEntity)
            }
        }
    }

    val getToken = appDatabase.query<TokenEntity>().find().asFlow()

    fun deleteToken() = appDatabase.query<TokenEntity>().find().delete()
}
