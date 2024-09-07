package com.example.jetpackretrofit.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.jetpackretrofit.models.Post
import com.example.jetpackretrofit.viewmodel.PostViewModel

@Composable
fun PostPage(postViewModel: PostViewModel){
    //val posts by postViewModel.posts.observeAsState(emptyList())
    val posts = postViewModel.posts.value
    LazyColumn {
        items(posts){item->
            Text(text = item.title)
            Text(text = "-")
            Text(text = item.body)
            Text(text = "----")
        }
    }
    DisposableEffect(Unit) {
        postViewModel.getPosts()
        onDispose {}
    }
}