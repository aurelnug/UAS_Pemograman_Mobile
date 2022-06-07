package com.example.uas_pemograman_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/top-headlines"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface InewsServiceApi {
    @GET("?country=id&category=health&apiKey=6d99020b5ad44776968a23e7b160c064")
    suspend fun getInews() : Inews
}

object InewsApi {
    val retrofitServiceApi: InewsServiceApi by lazy {
        retrofit.create(InewsServiceApi::class.java)
    }
}