package com.ugg.movieapp.models.artists

data class ArtistResult(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<ArtistKnownFor>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)