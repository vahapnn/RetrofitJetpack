package com.example.jetpackretrofit.retrofit

import com.example.jetpackretrofit.service.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL="https://jsonplaceholder.typicode.com/"
    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val postService:PostService= getInstance().create(PostService::class.java)
}