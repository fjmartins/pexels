package com.fjmartins.pexels.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fjmartins.pexels.repository.PexelRepository
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(private val repository: PexelRepository)  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}