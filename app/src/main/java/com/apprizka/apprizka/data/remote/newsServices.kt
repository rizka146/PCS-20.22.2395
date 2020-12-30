package com.example.apprizka.data.repository

import com.example.apprizka.data.remote.NewsServices
import com.example.apprizka.data.remote.RetrofitApi
import java.lang.Exception

class NewsRepository
private val newsServices: NewsServices by lazy{ RetrofitApi.newsService() }

suspend fun listNews() : ActionState<List<News>>{
    return try {
        val list = newsServices.listNews().await()
        ActionState(list.data)
    } catch (e: Exception){
        ActionState(message = e.message,isSuccess - false)
    }
}

suspend fun detailNews(url:String) : ActionState<News>{
    return try {
        val list = newsService.detailNews(url).await()
        ActionState(list.data.first())
    }catch (e: Exception){
        ActionState(message = e.message, isSuccess = false)
    }
}

suspend fun searchNews(query:String) : ActionState<List<News>>{
    return try {
        val list = newsService.searchnews(query).await()
        ActionState(list.data)
    }catch (e: Exception){

        ActionState(message = e.message,isSuccess = false)
    }
}

