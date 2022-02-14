package com.vickikbt.shared.data.repositories.profile_repository


/*class ProfileRepositoryImpl constructor(private val apolloClient: ApolloClient) :ProfileRepository {

    override suspend fun getLoggedInUserProfile(login: String): Response<UserProfileQuery.Data> {
        return apolloClient.query(
            UserProfileQuery(
                login,
                Input.optional(3),
                Input.optional(6),
                Input.optional(6),
                Input.optional(10),
                Input.optional(false)
            )
        ).await()
    }

}*/