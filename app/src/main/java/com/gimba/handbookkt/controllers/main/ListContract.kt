package com.gimba.handbookkt.controllers.main

import com.gimba.handbookkt.entity.Article


interface ListContract{
    interface View{
        fun showArticles(articles: List<Article>)
    }
    interface Presenter{
        fun loadArticles()
    }

    interface Model{
        fun loadFromNet():List<Article>?
        fun loadAllArticles():List<Article>?
    }
}