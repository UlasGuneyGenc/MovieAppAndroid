package com.ugg.movieapp.repository

import com.ugg.movieapp.api.RetrofitInstance
import com.ugg.movieapp.models.GenresModel

class Repository {

    suspend fun getGenres(): GenresModel{
        return RetrofitInstance.api.getGenres()
    }
}