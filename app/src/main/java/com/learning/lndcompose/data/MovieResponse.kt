package com.learning.lndcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("Search") var movies: ArrayList<Movie> = arrayListOf(),
    @SerializedName("totalResults") var totalResults: String? = null,
    @SerializedName("Response") var response: String? = null

)

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("Title") var title: String? = null,
    @SerializedName("Year") var year: String? = null,
    @SerializedName("imdbID") var imdbID: String? = null,
    @SerializedName("Type") var type: String? = null,
    @SerializedName("Poster") var poster: String? = null
)