package com.example.myapplication.T01_Menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.myapplication.R

class T01_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t01__menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_item1) {
            Log.d("menu", "item1 selected")
        } else if(item.itemId == R.id.menu_item2) {
            Toast.makeText(this, "menuitem2", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
