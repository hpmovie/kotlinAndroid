package com.example.myapplication.T09_XML

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t09__x_m_l.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL


class T09_XML : AppCompatActivity() {
    data class MyWeatherData(val hour:Int, val day:Int, val temp:Float, val wfkor:String)
    val myWeatherList = ArrayList<MyWeatherData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t09__x_m_l)

        WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
    }

    inner class WeatherTask:AsyncTask<String, Unit, String>() {
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tvWeather.text = result
        }
        override fun doInBackground(vararg params: String?): String {
            val path = params[0]!!
            val url = URL(path)

            val factory = XmlPullParserFactory.newInstance()
            val xpp = factory.newPullParser()
            xpp.setInput(url.openStream(), "utf-8")

            var bRead = false;
            var res = ""
            var eventType = xpp.eventType
            while(eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_TAG)
                    bRead = when(xpp.name) {
                        "hour", "day", "temp", "wfKor" -> true
                        else -> false
                 } else if(eventType == XmlPullParser.TEXT) {
                    if(bRead) {
                        res += xpp.text + "\n"
                        bRead = false
                    }
                }

                eventType = xpp.next()
            }
            return res;
        }
    }
}
