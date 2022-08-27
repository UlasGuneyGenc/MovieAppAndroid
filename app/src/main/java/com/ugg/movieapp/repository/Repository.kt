package com.ugg.movieapp.repository

import com.ugg.movieapp.api.MovieAPI
import com.ugg.movieapp.models.artists.ArtistResult
import com.ugg.movieapp.models.artists.ArtistsModel
import com.ugg.movieapp.models.genres.GenresModel
import com.ugg.movieapp.util.Resource
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: MovieAPI
) {

    suspend fun getGenres(): Resource<GenresModel?>{
        val response = try {
            api.getGenres()
        }catch (e: Exception){
           return Resource.Error("Error in network call for getting genres")
        }
        return Resource.Success(response.body())
    }

    suspend fun getPopularPersons(): Resource<ArtistsModel?>{
        val response = try {
            api.getPopularPersons()
        }catch (e: Exception){
            return Resource.Error("Error in network call for getting popular people")
        }
        return Resource.Success(response.body())
    }
}