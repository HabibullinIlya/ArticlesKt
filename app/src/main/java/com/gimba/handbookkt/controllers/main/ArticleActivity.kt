package com.gimba.handbookkt.controllers.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.gimba.handbookkt.R

/**
 * Created by gimba on 22.05.2018.
 */
class ArticleActivity: AppCompatActivity(){
    var articleTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_article)
        var intent = getIntent()
        setTitle(intent.getStringExtra("name"))
        articleTextView = findViewById(R.id.text)
        articleTextView!!.setText(intent.getStringExtra("text"))
    }
}