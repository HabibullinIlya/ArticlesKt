package com.gimba.handbookkt.controllers.main

import android.content.Context
import android.util.Log
import com.gimba.handbookkt.MyRetrofit
import com.gimba.handbookkt.database.ArticleController
import com.gimba.handbookkt.entity.Article
import com.gimba.handbookkt.network.ArticlesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListActivityPresenter:ListContract.Presenter{

    private var mView: ListContract.View
    private var mModel: ListContract.Model
    private var context: Context
    constructor(view:ListContract.View,_context: Context){
        context = _context
        this.mView = view
        this.mModel = ArticleRepository()
    }
    var articles: List<Article>? = null
    override fun loadArticles(){
        var articleController = ArticleController(context)
        //Log.d("TAG", articleController.loadAllArticles()!![1].toString())

        var r = MyRetrofit()
        r.retrofit!!.create(ArticlesApi::class.java).getAllArticles().enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                articles = response.body()
                articleController.saveArticleData(articles!![1])
                mView.showArticles(articles!!)
            }
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
            }
        })

    }
}