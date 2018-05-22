package com.gimba.handbookkt.network

import com.gimba.handbookkt.entity.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticlesApi{
    @GET("/articlesjava/handbook/getAllArticles")
    fun getAllArticles(): Call<List<Article>>
}