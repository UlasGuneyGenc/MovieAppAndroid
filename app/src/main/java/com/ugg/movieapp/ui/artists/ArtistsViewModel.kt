package com.ugg.movieapp.ui.artists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugg.movieapp.models.artists.ArtistResult
import com.ugg.movieapp.models.genres.GenresModel
import com.ugg.movieapp.repository.Repository
import com.ugg.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Resource<ArtistResult?>> = MutableLiveData()

    fun getPopularPersons(){
        myResponse.value = Resource.Loading()
        viewModelScope.launch {
            val response = repository.getPopularPersons()
            myResponse.value = response
        }
    }

    init {
        getPopularPersons()
    }
}