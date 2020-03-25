package com.example.myapplication.T10_Recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class T10_Recycleview : AppCompatActivity() {

    data class MyData(val title:String, val desc:String, val img:Int)
    val myList = ArrayList<MyData>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t10__recycleview)
    }

    fun generateData() {
        val icons = arrayOf(R.drawable.ic_navigation_black_24dp,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
        for(i in 0..100) {
            val icon = icons[i%3]
            myList.add(MyData("title $i", "desc $i", icon))
        }
    }
}
