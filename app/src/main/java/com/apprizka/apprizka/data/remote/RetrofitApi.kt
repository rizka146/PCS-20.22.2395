package com.apprizka.apprizka.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.apprizka.apprizka.data.local.AuthPref
import com.apprizka.apprizka.data.model.ActionState
import com.apprizka.apprizka.data.model.AuthUser

import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val NEWS_URL = "https://www.news.developeridn.com/hiburan"

    private val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            })
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

    private fun create(url: String) : Retrofit{
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }

    fun newsService() : NewsServices{
        return create(NEWS_URL).create(NewsServices::class.java)
    }


}