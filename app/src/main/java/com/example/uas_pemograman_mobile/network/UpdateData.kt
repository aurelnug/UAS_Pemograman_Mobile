package com.example.uas_pemograman_mobile.network

data  class UpdateData (
    val list_data: List<UpdateDataItem>? = null,
)

data class UpdateDataItem (
    val key: String? = null,
    val jumlah_kasus: Int? = null,
    val jumlah_sembuh: Int? = null,
    val jumlah_meninggal: Int? = null,
    val jumlah_dirawat: Int? = null,
)
