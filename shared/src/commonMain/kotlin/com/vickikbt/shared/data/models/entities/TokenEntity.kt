package com.vickikbt.shared.data.models.entities

import io.realm.RealmObject

class TokenEntity : RealmObject {
    var accessToken: String? = null

    var scope: String? = null

    var tokenType: String? = null
}
