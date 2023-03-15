package com.theandroidfactory.ricknmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val repository = Repository()

    private val _character = MutableLiveData<Character?>()
    val character: LiveData<Character?> = _character

    fun refreshCharacter(id: Int) {
        viewModelScope.launch {
            _character.postValue(repository.getCharacterById(id))
        }
    }
}