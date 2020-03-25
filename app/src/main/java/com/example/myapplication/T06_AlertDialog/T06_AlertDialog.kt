package com.example.myapplication.T06_AlertDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class T06_AlertDialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t06__alert_dialog)

        val myView = layoutInflater.inflate(R.layout.dialog_view, null)
        val editTextDialog = myView.findViewById<EditText>(R.id.editTextDialog)
        val builder = AlertDialog.Builder(this)
        val positiveButton = builder
            .setView(myView)
            .setTitle("hello title")
            .setMessage("hello message")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "hello ok button ${editTextDialog.text}", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("cancel") { dialog, which ->
                Toast.makeText(this, "hello cancel button", Toast.LENGTH_SHORT).show()
            }.show()
    }
}
