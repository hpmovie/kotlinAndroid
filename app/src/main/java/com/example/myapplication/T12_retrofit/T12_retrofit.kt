package com.example.myapplication.T12_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

class T12_retrofit : AppCompatActivity() {
    data class MyPost(val userId:Int, val id:Int, val title:String, val body:String)
    interface MyTypicodeInterface {
        @GET("posts")
        fun getPosts(): Call<List<MyPost>>

        @GET("posts/{id}")
        fun getPost(@Path("id") id:Int): Call<MyPost>

        @POST("posts")
        fun createPost(@Body post:MyPost) : Call<MyPost>

    }
    lateinit var myTypicode:MyTypicodeInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t12_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        myTypicode = retrofit.create(MyTypicodeInterface::class.java)
       // getPosts()
       // getPost(100)
        createPost()
    }

    fun createPost() {
        val post = MyPost(11, 12, "my title", "my body")
        val call = myTypicode.createPost(post)
        call.enqueue(object: Callback<MyPost> {
            override fun onFailure(call: Call<MyPost>, t: Throwable) {

            }

            override fun onResponse(call: Call<MyPost>, response: Response<MyPost>) {
                val post = response.body()
                Log.d("post", "create post ${post.toString()}")
            }

        })

    }

    fun getPost(id:Int) {
        val call = myTypicode.getPost(id)
        call.enqueue(object: Callback<MyPost> {
            override fun onFailure(call: Call<MyPost>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MyPost>, response: Response<MyPost>) {
                if(response.isSuccessful == false) {
                    Toast.makeText(this@T12_retrofit, "error ${response.code()}", Toast.LENGTH_SHORT).show()
                    return
                }
                val post = response.body()
                Log.d("post", post.toString())
            }

        })
    }

    fun getPosts() {
        val call = myTypicode.getPosts()
        call.enqueue(object: Callback<List<MyPost>> {
            override fun onFailure(call: Call<List<MyPost>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<MyPost>>, response: Response<List<MyPost>>) {
                if(response.isSuccessful == false) {
                    Toast.makeText(this@T12_retrofit, "error ${response.code()}", Toast.LENGTH_SHORT).show()
                    return
                }
                val posts = response.body()
                if(posts != null) {
                    for(post in posts) {
                        Log.d("posts", post.toString())
                    }

                }
            }

        })
    }
}
