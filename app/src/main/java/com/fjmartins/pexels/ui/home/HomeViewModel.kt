package com.fjmartins.pexels.ui.home

import androidx.databinding.ObservableBoolean
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
    val loading = ObservableBoolean(false)
    val empty = ObservableBoolean(false)

    fun getImages(query: String) {
        loading.set(true)

        viewModelScope.launch {
            val response = repository.getImages(query)
            val photos = response?.photos.orEmpty()
            _photos.postValue(photos)
            empty.set(photos.isEmpty())

            loading.set(false)
        }
    }
}