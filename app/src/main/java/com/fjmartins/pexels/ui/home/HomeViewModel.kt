package com.fjmartins.pexels.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjmartins.pexels.repository.PexelRepository
import kotlinx.coroutines.launch

import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: PexelRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getImages() {
        viewModelScope.launch {
            val response = repository.getImages("Flowers")
            Log.d("response ", response.toString())
        }
    }
}