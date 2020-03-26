package com.example.myapplication.T11_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.google.gson.Gson
import org.json.JSONArray

class T11_Json : AppCompatActivity() {
    data class User(val name:String, val tel:String, val age:Int)

    val str = "[{'name':'kim', 'tel':'000-111-2222', 'age':11}, " +
            "{'name':'park', 'tel':'111-222-3333', 'age':12}, " +
            "{'name':'lee', 'tel':'222-333-4444', 'age':13}]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t11__json)
       // parsingJSON()
        parsingWithGSON()
    }

    fun parsingWithGSON() {
        val myList = Gson().fromJson(str, Array<User>::class.java)

        for(obj in myList) {
            Log.d("gson", obj.toString())
        }
    }

    fun parsingJSON() {
        val myList = ArrayList<User>()
        val array = JSONArray(str)
        for(i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            val name = obj.getString("name")
            val tel = obj.getString("tel")
            val age = obj.getInt("age")

            val user = User(name,tel,age)
            myList.add(user)
        }
    }
}
