package com.example.myapplication.T08_AsyncTask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t08__async_task.*

class T08_AsyncTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t08__async_task)

        btnAsyncTask.setOnClickListener {
            val task = MyTask()
            task.execute(30)
        }
    }

    inner class MyTask : AsyncTask<Int, Float, String>() {

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(this@T08_AsyncTask, result, Toast.LENGTH_SHORT).show()
        }


        override fun onProgressUpdate(vararg values: Float?) {
            super.onProgressUpdate(*values)
            btnAsyncTask.text = "count ${values[0]}"
        }

        override fun doInBackground(vararg params: Int?): String {
            val start: Int = params[0] ?: 0
            for(i in start..100) {
                Thread.sleep(100)
                publishProgress(i.toFloat())
            }
            return "Count is done."
        }

    }
}
