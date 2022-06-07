package com.example.uas_pemograman_mobile.network

data  class Inews (
    val articles: List<InewsItem>? = null,
)

data class InewsItem (
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null,
)