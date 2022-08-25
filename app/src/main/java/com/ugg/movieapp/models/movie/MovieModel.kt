package com.ugg.movieapp.models.movie

import com.google.gson.annotations.SerializedName

data class MovieModel (
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val genre_ids: List<Int>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)