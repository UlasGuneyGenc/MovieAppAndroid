package com.ugg.movieapp.models.artists

data class ArtistsModel(
    val page: Int,
    var results: List<ArtistResult>,
    val total_pages: Int,
    val total_results: Int
)