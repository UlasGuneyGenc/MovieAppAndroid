package com.ugg.movieapp.models

data class SearchResultsModel(
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)