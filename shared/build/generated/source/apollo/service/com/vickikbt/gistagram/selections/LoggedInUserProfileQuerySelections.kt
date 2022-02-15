//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.0.0'.
//
package com.vickikbt.gistagram.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledIntType
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledStringType
import com.apollographql.apollo3.api.notNull
import com.vickikbt.gistagram.type.FollowerConnection
import com.vickikbt.gistagram.type.FollowingConnection
import com.vickikbt.gistagram.type.User
import kotlin.collections.List

public object LoggedInUserProfileQuerySelections {
  private val followers: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "totalCount",
          type = CompiledIntType.notNull()
        ).build()
      )

  private val following: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "totalCount",
          type = CompiledIntType.notNull()
        ).build()
      )

  private val viewer: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "bio",
          type = CompiledStringType
        ).build(),
        CompiledField.Builder(
          name = "company",
          type = CompiledStringType
        ).build(),
        CompiledField.Builder(
          name = "email",
          type = CompiledStringType.notNull()
        ).build(),
        CompiledField.Builder(
          name = "followers",
          type = FollowerConnection.type.notNull()
        ).selections(followers)
        .build(),
        CompiledField.Builder(
          name = "following",
          type = FollowingConnection.type.notNull()
        ).selections(following)
        .build()
      )

  public val root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "viewer",
          type = User.type.notNull()
        ).selections(viewer)
        .build()
      )
}
