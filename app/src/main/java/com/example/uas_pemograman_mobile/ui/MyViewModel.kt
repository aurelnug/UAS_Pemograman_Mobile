package com.example.uas_pemograman_mobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_pemograman_mobile.network.*
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE}
class MyViewModel: ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    private val _inews = MutableLiveData<List<InewsItem>?> ()
    val inews: LiveData<List<InewsItem>?> = _inews

    private val _inew = MutableLiveData<InewsItem>()
    val inew: LiveData<InewsItem> = _inew

    private val _RumahSakits = MutableLiveData<List<RumahSakit>>()
    val RumahSakits: LiveData<List<RumahSakit>> = _RumahSakits

    private val _RumahSakit = MutableLiveData<RumahSakit>()
    val RumahSakit: LiveData<RumahSakit> = _RumahSakit

    private val _updateDatas = MutableLiveData<List<UpdateDataItem>?>()
    val updateDatas: LiveData<List<UpdateDataItem>?> = _updateDatas

    private  val _updateData = MutableLiveData<UpdateDataItem>()
    val updateData: LiveData<UpdateDataItem> = _updateData

    fun getInews() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _inews.value = InewsApi.retrofitServiceApi.getInews().articles
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _inews.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getRumahSakit() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _RumahSakits.value = RumahSakitApi.retrofitServiceApi.getRumahSakit()
                _status.value = ApiStatus.DONE
            } catch (e: java.lang.Exception) {
                _RumahSakits.value = listOf()
                _status.value = ApiStatus.ERROR

            }
        }
    }

    fun getUpdateData() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _updateDatas.value = UpdateDataApi.retrofitServiceApi.getUpdateData().list_data
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _updateDatas.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }
    fun onInewsClicked(inews: InewsItem) {
        _inew.value = inews
    }

    fun onRumahSakitClicked(rs: RumahSakit) {
        _RumahSakit.value = rs
    }

    fun onUpdateDataClicked(update: UpdateDataItem) {
        _updateData.value = update
    }
}


