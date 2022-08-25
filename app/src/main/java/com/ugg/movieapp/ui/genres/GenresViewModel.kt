package com.ugg.movieapp.ui.genres

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugg.movieapp.models.genres.GenresModel
import com.ugg.movieapp.repository.Repository
import com.ugg.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Resource<GenresModel?>> = MutableLiveData()

    fun getGenres(){
        myResponse.value = Resource.Loading()
        viewModelScope.launch {
            val response = repository.getGenres()
            myResponse.value = response
        }
    }

    init {
        getGenres()
    }
}