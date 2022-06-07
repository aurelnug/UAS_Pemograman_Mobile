package com.example.uas_pemograman_mobile.ui.update_covid19

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_pemograman_mobile.network.InewsApi
import com.example.uas_pemograman_mobile.network.InewsItem
import com.example.uas_pemograman_mobile.network.UpdateDataApi
import com.example.uas_pemograman_mobile.network.UpdateDataItem
import kotlinx.coroutines.launch

enum class ApiStatusUpdate { LOADING, ERROR, DONE}

class UpdateDataViewModel: ViewModel() {
    private val _status = MutableLiveData<ApiStatusUpdate>()
    val status: LiveData<ApiStatusUpdate> = _status

    private val _updateDatas = MutableLiveData<List<UpdateDataItem>?>()
    val updateDatas: LiveData<List<UpdateDataItem>?> = _updateDatas

    private  val _updateData = MutableLiveData<UpdateDataItem>()
    val updateData: LiveData<UpdateDataItem> = _updateData

    fun getUpdateData() {
        viewModelScope.launch {
            _status.value = ApiStatusUpdate.LOADING
            try {
                _updateDatas.value = UpdateDataApi.retrofitServiceApi.getUpdateData().list_data
                _status.value = ApiStatusUpdate.DONE
            } catch (e: Exception) {
                _updateDatas.value = listOf()
                _status.value = ApiStatusUpdate.ERROR
            }
        }
    }

    fun onUpdateDataClicked(update: UpdateDataItem) {
        _updateData.value = update
    }

}