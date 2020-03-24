package com.example.myapplication.T04_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t04__list_view.*

class T04_ListView : AppCompatActivity() {

    val myData = arrayOf("hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t04__list_view)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, myData)

        myListView.adapter = adapter
        myListView.setOnItemClickListener { parent, view, position, id ->
            val str = myData[position]
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }
    }
}
