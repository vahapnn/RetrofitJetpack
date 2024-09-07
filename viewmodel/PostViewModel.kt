package com.example.jetpackretrofit.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackretrofit.models.Post
import com.example.jetpackretrofit.repository.Repository
import com.example.jetpackretrofit.retrofit.RetrofitInstance
import com.example.jetpackretrofit.service.PostService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class PostViewModel:ViewModel() {
    var postService:PostService=RetrofitInstance.postService
   // private var _posts=MutableLiveData<List<Post>>()
     //       var posts:LiveData<List<Post>> =_posts
    val posts: MutableState<List<Post>> = mutableStateOf(emptyList())
    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    private val repository=Repository()
    fun getPosts(){
        viewModelScope.launch {
            try {
                val response=postService.getPosts()
                if (response.isNotEmpty()){
                    posts.value=response
                    //posts.value=response
                }
            }catch (e:Exception){}
        }
    }
    fun pushPost(post: Post){
      viewModelScope.launch {
          val response=repository.pushPost(post)
          myResponse.value=response
          //repository.pushPost(post)
      }
    }
}