package com.techmashinani.filamu.model

import com.google.gson.annotations.SerializedName

data class Person(val birthday: String?,
                  @SerializedName("known_for_department")
                  val department: String,
                  @SerializedName("deathday")
                  val deathDay: String?,
                  val id: Long,
                  val name: String,

                  @SerializedName("also_known_as")
                  val otherNames: List<String>,

                  val gender: Int,
                  val biography: String,
                  val popularity: Float,

                  @SerializedName("place_of_birth")
                  val placeOfBirth: String,

                  val profile_path: String,
                  val imdb_id: String,
                  val homepage: String?)