package com.example.myapplication.T03_Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t03__new.*

class T03_NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t03__new)
        val value = intent.getIntExtra("hello", 0)

        btnResult.setOnClickListener {
            val resIndent = Intent()
            resIndent.putExtra("resValue", "hello request")
            setResult(Activity.RESULT_OK, resIndent)
            finish()
        }
    }
}
