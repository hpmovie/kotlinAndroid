package com.example.myapplication.T20_style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t20_style2.*

class T20_style : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t20_style2)
        val numberListener = View.OnClickListener {
            val btn = it as Button
            val value = btn.text.toString()
            val working = tvWorking.text.toString()
            if(working == "0")
                tvWorking.text = value
            else
                tvWorking.text = "${working}${value}"

        }
        btnOne.setOnClickListener(numberListener)
        btnZero.setOnClickListener(numberListener)
        /*btnOne.setOnClickListener{
            val value = tvWorking.text
            tvWorking.text = "${value}1"
        }
        btnZero.setOnClickListener{
            val value = tvWorking.text
            tvWorking.text = "${value}0"
        }*/


        var number = 1
        for(i in 2 until rootLayout.childCount - 1 ){
            val row = rootLayout.getChildAt(i) as LinearLayout
            for(k in 0 until row.childCount){
                val btn = row.getChildAt(k) as Button
                btn.text = "$number"
                number += 1
                btn.setOnClickListener(numberListener)
            }
        }
        val index = rootLayout.childCount - 1
        val lastRow = rootLayout.getChildAt(index) as LinearLayout
        val btnCancel = lastRow.getChildAt(0) as Button
        btnCancel.text = "cancel"
        btnCancel.setOnClickListener { tvWorking.text = "0" }

        val zeroBtn = lastRow.getChildAt(1) as Button
        zeroBtn.text = "0"
        zeroBtn.setOnClickListener(numberListener)

        val btnEnter = lastRow.getChildAt(2) as Button
        btnEnter.text = "enter"

        btnEnter.setOnClickListener{
            tvSelected.text = tvWorking.text
            tvWorking.text = "0"
        }
    }
}
