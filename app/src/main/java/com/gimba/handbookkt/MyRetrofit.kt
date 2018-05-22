package com.gimba.handbookkt

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gimba on 20.05.2018.
 */
class MyRetrofit{
     var retrofit: Retrofit? = null
     private val baseUrl: String = "http://ilyaxabibullin.xyz/"


     constructor(){
        var interspector = HttpLoggingInterceptor()
        interspector.setLevel(HttpLoggingInterceptor.Level.BODY)
        var client = OkHttpClient.Builder().addInterceptor(interspector).build()

        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }
}