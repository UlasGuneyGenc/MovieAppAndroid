package com.ugg.movieapp.api

import com.ugg.movieapp.models.GenresModel
import com.ugg.movieapp.models.MovieModel
import com.ugg.movieapp.models.SearchResultsModel
import com.ugg.movieapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key")
        apiKey: String = API_KEY
    ): GenresModel
}