package com.gimba.handbookkt.controllers.main

import android.content.Context
import android.util.Log
import com.gimba.handbookkt.MyRetrofit
import com.gimba.handbookkt.database.ArticleController
import com.gimba.handbookkt.database.ArticleTable
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
        articleController.clearTable(ArticleTable.TABLE_NAME)

        var r = MyRetrofit()
        r.retrofit!!.create(ArticlesApi::class.java).getAllArticles().enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                articles = response.body()
                for(i in 0 until articles!!.size){
                    println(i)
                    articleController.saveArticleData(articles!![i])
                    print(articles!!.toString())
                }

                //println(articleController.loadAllArticles()!![1].articleText)
                print(articleController.loadAllArticles()!![1].nameActicle)
                mView.showArticles(articleController.loadAllArticles()!!);

            }
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
            }
        })

    }
}