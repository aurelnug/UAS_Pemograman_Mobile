package com.example.uas_pemograman_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.covid19.go.id/public/api"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UpdateDataServiceApi {
    @GET("/prov.json")
    suspend fun getUpdateData() : UpdateData
}

object UpdateDataApi {
    val retrofitServiceApi: UpdateDataServiceApi by lazy {
        retrofit.create(UpdateDataServiceApi::class.java)
    }
}