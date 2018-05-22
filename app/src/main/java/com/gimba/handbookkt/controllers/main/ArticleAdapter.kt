package com.gimba.handbookkt.controllers.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.gimba.handbookkt.MyRetrofit
import com.gimba.handbookkt.R
import com.gimba.handbookkt.entity.Article
import com.gimba.handbookkt.R.id.rv
import com.gimba.handbookkt.network.ArticlesApi
import com.gimba.handbookkt.utils.OnItemClickListener

import retrofit2.Callback

import retrofit2.Call
import retrofit2.Response


class ArticleAdapter(private val articleList: List<Article>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ArticleVH(v)
    }


    override fun getItemCount(): Int {
        return articleList.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val articleVH = holder as ArticleVH
        articleVH.articleHeader.setText(articleList[position].nameActicle)
        articleVH.articleText.setText(articleList[position].tags)
    }

    private inner class ArticleVH
    //ImageView articleImage;

    (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var cv: CardView
        internal var articleHeader: TextView
        internal var articleText: TextView

        init {
            cv = itemView.findViewById(R.id.cv)
            articleHeader = itemView.findViewById(R.id.article_name)
            articleText = itemView.findViewById(R.id.article_tags)
            cv.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            onItemClickListener!!.onItemClick(adapterPosition, view)
        }
    }
}
