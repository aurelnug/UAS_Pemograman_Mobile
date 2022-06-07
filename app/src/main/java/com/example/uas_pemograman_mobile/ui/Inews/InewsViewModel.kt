package com.example.uas_pemograman_mobile.ui.Inews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_pemograman_mobile.network.InewsApi
import com.example.uas_pemograman_mobile.network.InewsItem
import kotlinx.coroutines.launch

enum class ApiStatusInews { LOADING, ERROR, DONE}

class InewsViewModel: ViewModel() {

    private val _status = MutableLiveData<ApiStatusInews>()
    val status: LiveData<ApiStatusInews> = _status

    private val _inews = MutableLiveData<List<InewsItem>?> ()
    val inews: LiveData<List<InewsItem>?> = _inews

    private val _inew = MutableLiveData<InewsItem>()
    val inew: LiveData<InewsItem> = _inew

    fun getInews() {
        viewModelScope.launch {
            _status.value = ApiStatusInews.LOADING
            try {
                _inews.value = InewsApi.retrofitServiceApi.getInews().articles
                _status.value = ApiStatusInews.DONE
            } catch (e: Exception) {
                _inews.value = listOf()
                _status.value = ApiStatusInews.ERROR
            }
        }
    }

    fun onInewsClicked(inews: InewsItem) {
        _inew.value = inews
    }


}