package com.example.myapplication.T21_Camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t21__camera.*
import java.util.*

class T21_Camera : AppCompatActivity() {
    val REQ_CAMERA =100
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t21__camera)

        btnCamera.setOnClickListener {
            val myIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)  // 암시적 인텐트 사용
            startActivityForResult(myIntent, REQ_CAMERA)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQ_CAMERA) {
            if(resultCode == Activity.RESULT_OK) {
                val bitmap = data?.extras?.get("data") as Bitmap
                imageViewPicture.setImageBitmap(bitmap)
            }

        }
    }
}
