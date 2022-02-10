package com.vickikbt.gistagram.utils

object Constants {

    const val CLIENT_ID = "636476aaacea074a6883"
    const val CLIENT_SECRET = "0f5a4cf3981bfec70b138399e2d9ef7713ed90c0"
    const val REDIRECT_URL = "vickikbt://callback"

    const val GITHUB_OAUTH_URL =
        "https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_url=$REDIRECT_URL"

    const val BASE_URL = "https://api.github.com/graphql"

}