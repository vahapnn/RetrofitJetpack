package com.example.jetpackretrofit.service

import com.example.jetpackretrofit.models.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostService {
    @GET("posts")
    suspend fun getPosts():List<Post>
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ):Response<Post>
}