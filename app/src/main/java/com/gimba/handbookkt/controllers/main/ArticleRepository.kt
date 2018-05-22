package com.gimba.handbookkt.controllers.main

import com.gimba.handbookkt.MyRetrofit
import com.gimba.handbookkt.entity.Article
import com.gimba.handbookkt.network.ArticlesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by gimba on 20.05.2018.
 */
class ArticleRepository:ListContract.Model {
    override fun loadAllArticles(): List<Article>? {
        return null
    }

    override fun loadFromNet():List<Article>? {
        var r = MyRetrofit()
        var response = r.retrofit!!.create(ArticlesApi::class.java).getAllArticles().execute()
        return response.body()
    }
}