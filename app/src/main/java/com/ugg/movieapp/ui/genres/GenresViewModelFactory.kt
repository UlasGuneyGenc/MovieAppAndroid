package com.ugg.movieapp.ui.genres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ugg.movieapp.repository.Repository

class GenresViewModelFactory(private val repository: Repository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenresViewModel(repository) as T
    }
}