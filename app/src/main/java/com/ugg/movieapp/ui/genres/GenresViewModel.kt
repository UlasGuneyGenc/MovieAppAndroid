package com.ugg.movieapp.ui.genres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugg.movieapp.models.GenresModel
import com.ugg.movieapp.repository.Repository
import kotlinx.coroutines.launch

class GenresViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<GenresModel> = MutableLiveData()

    fun getGenres(){
        viewModelScope.launch {
            val response = repository.getGenres()
            myResponse.value = response
        }
    }
}