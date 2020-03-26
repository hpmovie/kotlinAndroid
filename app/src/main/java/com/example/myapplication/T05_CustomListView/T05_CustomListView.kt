package com.example.myapplication.T05_CustomListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t05__custom_list_view.*
import kotlinx.android.synthetic.main.item_custom_listview.*

class T05_CustomListView : AppCompatActivity() {
    data class MyData(val title:String, val desc:String, val img:Int)
    val myList = ArrayList<MyData>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t05__custom_list_view)
        generateData()
        val myAdapter = MyCustomAdapter()
        customListView.adapter = myAdapter
        btnReload.setOnClickListener {
            generateData()
            myAdapter.notifyDataSetChanged()
        }

    }

    fun generateData() {
        val icons = arrayOf(R.drawable.ic_navigation_black_24dp,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
        for(i in 0..100) {
            val icon = icons[i%3]
            myList.add(MyData("title $i", "desc $i", icon))
        }
    }
    // inner class 사용안하면 myList를 생성자에 전달해줘야 함
    inner class MyCustomAdapter:BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var v = convertView
            if(v == null) {
                v = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_custom_listview, parent, false)
            }

            val data = myList[position]
            val tvTitle: TextView = v!!.findViewById(R.id.tvTitle)
            val tvDesc: TextView = v.findViewById(R.id.tvDesc)
            val itemImageView: ImageView = v.findViewById(R.id.itemImageView)
            tvTitle.text = data.title
            tvDesc.text = data.desc
            itemImageView.setImageResource(data.img)
            return v;
        }

        override fun getItem(position: Int): Any {
            return myList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return myList.size
        }

    }
}
