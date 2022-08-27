package com.ugg.movieapp.api

import com.ugg.movieapp.models.artists.ArtistResult
import com.ugg.movieapp.models.artists.ArtistsModel
import com.ugg.movieapp.models.genres.GenresModel
import com.ugg.movieapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieAPI {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("language")
        language: String = Locale.getDefault().toLanguageTag()
    ): Response<GenresModel>

    @GET("person/popular")
    suspend fun getPopularPersons(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("language")
        language: String = Locale.getDefault().toLanguageTag()
    ): Response<ArtistsModel>
}