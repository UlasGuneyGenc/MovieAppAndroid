package com.ugg.movieapp.ui.artists

import android.widget.Filter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugg.movieapp.models.artists.ArtistResult
import com.ugg.movieapp.models.artists.ArtistsModel
import com.ugg.movieapp.models.genres.GenresModel
import com.ugg.movieapp.repository.Repository
import com.ugg.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Resource<ArtistsModel?>> = MutableLiveData()
    var myFilteredResponse : MutableLiveData<Resource<ArtistsModel?>> = MutableLiveData()

    init {
        getPopularPersons()
    }

    fun getPopularPersons(){
        myResponse.value = Resource.Loading()
        viewModelScope.launch {
            val response = repository.getPopularPersons()
            myResponse.value = response
            myFilteredResponse.value = response
        }
    }

    fun filterResponse(constraint: CharSequence?): MutableLiveData<Resource<ArtistsModel?>> {
        val charString = constraint?.toString() ?: ""
        if (charString.isEmpty()) myFilteredResponse = myResponse else {
            val filteredList = ArrayList<ArtistResult>()
            myResponse.value?.data?.results
                ?.filter {
                    (it.name.contains(constraint!!))
                }
                ?.forEach { filteredList.add(it) }
            myFilteredResponse.value?.data?.results = filteredList
        }
        return myFilteredResponse
        }
}



