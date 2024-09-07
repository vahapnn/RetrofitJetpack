package com.example.jetpackretrofit.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackretrofit.models.Post
import com.example.jetpackretrofit.viewmodel.PostViewModel

@Composable
fun PostData2(postViewModel: PostViewModel,modifier:Modifier=Modifier){
    var body by remember {
        mutableStateOf("")
    }
    var title by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text(text = "Post Request")
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = body, onValueChange ={body=it},
            placeholder = { Text(text = "Lütfen yorumu giriniz...")},
            modifier = Modifier.padding(16.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = title, onValueChange = {title=it},
            placeholder = { Text(text = "Lütfen başlığı giriniz...")},
            modifier=Modifier.padding(16.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        ElevatedButton(onClick = {
            val post=Post(body,2,title,2)
            postViewModel.pushPost(post)
        }) {
            Text(text = "Gönder")
        }
    }
}