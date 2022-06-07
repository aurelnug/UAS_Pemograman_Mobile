package com.example.uas_pemograman_mobile.ui.RumahSakit_covid19

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_pemograman_mobile.network.RumahSakit
import com.example.uas_pemograman_mobile.network.RumahSakitApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatusRs { LOADING, ERROR, DONE}

class RumahSakitViewModel: ViewModel() {
    private val _status = MutableLiveData<ApiStatusRs>()
    val status: LiveData<ApiStatusRs> = _status

    private val _RumahSakits = MutableLiveData<List<RumahSakit>>()
    val RumahSakits: LiveData<List<RumahSakit>> = _RumahSakits

    private val _RumahSakit = MutableLiveData<RumahSakit>()
    val RumahSakit: LiveData<RumahSakit> = _RumahSakit

    fun getRumahSakit() {
        viewModelScope.launch {
            _status.value = ApiStatusRs.LOADING
            try {
                _RumahSakits.value = RumahSakitApi.retrofitServiceApi.getRumahSakit()
                _status.value = ApiStatusRs.DONE
            } catch (e: Exception) {
                _RumahSakits.value = listOf()
                _status.value = ApiStatusRs.ERROR

            }
        }
    }

    fun onRumahSakitClicked(rs: RumahSakit) {
        _RumahSakit.value = rs
    }

}