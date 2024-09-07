package com.example.jetpackretrofit.repository

import com.example.jetpackretrofit.models.Post
import com.example.jetpackretrofit.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class Repository {
    suspend fun pushPost(post: Post):Response<Post>{
        return RetrofitInstance.postService.pushPost(post)
    }
}