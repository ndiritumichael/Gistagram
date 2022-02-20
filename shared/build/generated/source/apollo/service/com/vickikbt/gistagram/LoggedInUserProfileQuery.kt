//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.1.0'.
//
package com.vickikbt.gistagram

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.vickikbt.gistagram.adapter.LoggedInUserProfileQuery_ResponseAdapter
import com.vickikbt.gistagram.selections.LoggedInUserProfileQuerySelections
import kotlin.Int
import kotlin.String
import kotlin.Unit

public class LoggedInUserProfileQuery() : Query<LoggedInUserProfileQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> {
    return LoggedInUserProfileQuery_ResponseAdapter.Data.obj()
  }

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.vickikbt.gistagram.type.Query.type
  )
  .selections(selections = LoggedInUserProfileQuerySelections.root)
  .build()

  public data class Data(
    /**
     * The currently authenticated user.
     */
    public val viewer: Viewer
  ) : Query.Data

  public data class Viewer(
    /**
     * The user's public profile bio.
     */
    public val bio: String?,
    /**
     * The user's public profile company.
     */
    public val company: String?,
    /**
     * The user's publicly visible profile email.
     */
    public val email: String,
    /**
     * A list of users the given user is followed by.
     */
    public val followers: Followers,
    /**
     * A list of users the given user is following.
     */
    public val following: Following
  )

  public data class Followers(
    /**
     * Identifies the total count of items in the connection.
     */
    public val totalCount: Int
  )

  public data class Following(
    /**
     * Identifies the total count of items in the connection.
     */
    public val totalCount: Int
  )

  public companion object {
    public const val OPERATION_ID: String =
        "2c55a6ac044e99a8094c2c9599098596d1fd87cd3512cca63a4166a067c1b9e4"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query LoggedInUserProfile {
     *   viewer {
     *     bio
     *     company
     *     email
     *     followers {
     *       totalCount
     *     }
     *     following {
     *       totalCount
     *     }
     *   }
     * }
     */
    public const val OPERATION_DOCUMENT: String =
        "query LoggedInUserProfile { viewer { bio company email followers { totalCount } following { totalCount } } }"

    public const val OPERATION_NAME: String = "LoggedInUserProfile"
  }
}
