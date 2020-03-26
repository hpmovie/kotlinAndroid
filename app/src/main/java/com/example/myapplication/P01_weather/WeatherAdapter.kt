package com.example.myapplication.P01_weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.T10_Recyclerview.MyRecyclerAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeatherAdapter(val myList:ArrayList<P01_weather.MyWeatherData>): RecyclerView.Adapter<WeatherAdapter.WeatherVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherVH {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_listview, parent, false)

        return WeatherVH(itemView)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: WeatherVH, position: Int) {
        val data = myList[position]
        holder.bind(data)

    }

    class WeatherVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)

        fun bind(data:P01_weather.MyWeatherData) {
            val cal = Calendar.getInstance()
            cal.add(Calendar.DATE, data.day)
            val df = SimpleDateFormat("yyyy-MM-dd")
            val strDate = df.format(cal.time)
            tvTitle.text = "${strDate} ${data.hour}시"
            tvDesc.text = "${data.wfkor} ${data.temp}c"
            val res = when{
                data.wfkor.contains("구름")-> R.drawable.ic_wb_cloudy_black_24dp
                data.wfkor.contains("비")-> R.drawable.ic_dialpad_black_24dp
                data.wfkor.contains("맑음")-> R.drawable.ic_wb_sunny_black_24dp
                else -> R.mipmap.ic_launcher
            }
            itemImageView.setImageResource(res)
        }
    }


}