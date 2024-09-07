package com.example.jetpackretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackretrofit.ui.PostData2
import com.example.jetpackretrofit.ui.postData
import com.example.jetpackretrofit.ui.theme.JetpackRetrofitTheme
import com.example.jetpackretrofit.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: PostViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                //PostPage(postViewModel = viewModel)
                PostData2(viewModel,modifier = Modifier.padding(innerPadding) )
                }
            }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackRetrofitTheme {
        Greeting("Android")
    }
}
/*val myPost=Post("Dilan polat tahliyesi",2,"Son dakika",2)
            viewModel.pushPost(myPost)
            viewModel.myResponse.observe(this, Observer { response->
                if (response.isSuccessful){
                    Log.d("Ekleme",response.body().toString())
                    Log.d("Ekleme",response.code().toString())
                    Log.d("Ekleme",response.message())
                }else{
                    Toast.makeText(this,response.code(),Toast.LENGTH_LONG).show()
                }
            })*/