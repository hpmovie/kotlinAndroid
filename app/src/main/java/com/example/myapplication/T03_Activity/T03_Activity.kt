package com.example.myapplication.T03_Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t03_.*

class T03_Activity : AppCompatActivity() {

    private val REQ_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t03_)

        btnNewActivity.setOnClickListener {
            var intent = Intent(this, T03_NewActivity::class.java)
            intent.putExtra("hello", 123)
            startActivityForResult(intent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                val myValue = data?.getStringExtra("resValue")
                Toast.makeText(this, myValue, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
