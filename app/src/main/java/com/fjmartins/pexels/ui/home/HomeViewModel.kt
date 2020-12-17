package com.fjmartins.pexels.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjmartins.pexels.model.Photo
import com.fjmartins.pexels.repository.PexelRepository
import kotlinx.coroutines.launch

import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: PexelRepository) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>().apply {
        value = ArrayList()
    }
    val photos: LiveData<List<Photo>> = _photos

    fun getImages(query: String) {
        viewModelScope.launch {
            val response = repository.getImages(query)
            _photos.postValue(response?.photos.orEmpty())
            Log.d("response ", response.toString())
        }
    }
}