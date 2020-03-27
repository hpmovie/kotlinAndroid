package com.example.myapplication.T18_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyBindService : Service() {

    inner class MyBinder: Binder() {
        fun getService(): MyBindService {
            return this@MyBindService
        }
    }
    val myBinder = MyBinder()
    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    val rand = Random()
    fun getRandomNumber():Int {
        return rand.nextInt(100)
    }
}
