package com.example.youtubeclone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeclone.data.models.User
import com.example.youtubeclone.data.service.Repository
import com.example.youtubeclone.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _data : MutableLiveData<Resource<User>> = MutableLiveData()
    val data : LiveData<Resource<User>> = _data

    fun getData(){
        _data.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getData()
            }.onSuccess {
                _data.postValue(Resource.Success(data = it))
            }.onFailure {
                _data.postValue(Resource.Failure(message = it.message))
            }
        }
    }
}