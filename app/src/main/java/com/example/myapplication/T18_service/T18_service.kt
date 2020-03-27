package com.example.myapplication.T18_service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t18_service.*

class T18_service : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t18_service)

        btnStart.setOnClickListener {
            val myIntent = Intent(
                this, MyService::class.java)
            startService(myIntent)
        }
        btnStop.setOnClickListener {
            val myIntent = Intent(
                this, MyService::class.java)
            stopService(myIntent)
        }

        btnNumber.setOnClickListener {
            if(myBindService != null)
                Toast.makeText(this, "number : ${myBindService?.getRandomNumber()}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        val myIntent = Intent(this, MyBindService::class.java)
        bindService(myIntent, conn, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(conn)
    }

    var myBindService: MyBindService? = null
    val conn = object: ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            myBindService = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder = service as MyBindService.MyBinder
            myBindService = myBinder.getService()
            //myBinder.getService().getRandomNumber()

        }


    }
}
