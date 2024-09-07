package com.example.jetpackretrofit.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.jetpackretrofit.MainActivity
import com.example.jetpackretrofit.models.Post
import com.example.jetpackretrofit.viewmodel.PostViewModel

@Composable
fun postData(postViewModel: PostViewModel, modifier: Modifier = Modifier) {
    val ctx = LocalContext.current

    val body = remember {
        mutableStateOf("")
    }
    val title = remember {
        mutableStateOf("")
    }
    val response = remember {
        mutableStateOf("")
    }
    // on below line we are creating a column.
    Column(
        // on below line we are adding a modifier to it
        // and setting max size, max height and max width
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are creating a text
        Text(
            // on below line we are specifying text as
            // Session Management in Android.
            text = "Retrofit POST Request in Android",
            // on below line we are specifying text color.
            color = Color.Green,
            fontSize = 20.sp,
            // on below line we are specifying font family
            fontFamily = FontFamily.Default,
            // on below line we are adding font weight
            // and alignment for our text
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        //on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our email.
        TextField(
            // on below line we are specifying value for our email text field.
            value = body.value,
            // on below line we are adding on value change for text field.
            onValueChange = { body.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your name") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our email.
        TextField(
            // on below line we are specifying value for our email text field.
            value = title.value,
            // on below line we are adding on value change for text field.
            onValueChange = { title.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your job") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))
        // on below line we are creating a button
        Button(
            onClick = {
                // on below line we are calling make payment method to update data.
                //postDataUsingRetrofit(
                  //  ctx, userName, job, response
               // )
                val post=Post(body.toString(),2, title.toString(),2)
                //val c:Call<Post?>? = postViewModel.pushPost2(post)
                postViewModel.pushPost(post)
            },
            // on below line we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }
        // on below line we are adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))
        // on below line we are creating a text for displaying a response.
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}