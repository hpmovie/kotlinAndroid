package com.example.myapplication.T19_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t19_fragment.*

class T19_fragment : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t19_fragment)
        btnAdd.setOnClickListener(this)
        btnRemove.setOnClickListener(this)
        btnReplace.setOnClickListener(this)
        btnHide.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val fragment = supportFragmentManager.findFragmentById(R.id.containerLayout)
        val tr = supportFragmentManager.beginTransaction()

        when(v?.id) {
            R.id.btnAdd -> {
                if(fragment == null) {
                    val newFragment = CounterFragment()
                    tr.add(R.id.containerLayout, newFragment, "counter").commit()
                }
            }
            R.id.btnRemove-> {
               // fragment?.run{tr.remove(fragment).commit() }
                if(fragment != null) {
                    tr.remove(fragment).commit()
                }
            }
            R.id.btnReplace-> {
                if(fragment != null) {
                    var newFragment = if(fragment.tag.equals("counter")) {
                        BlankFragment()
                    } else {
                        CounterFragment()
                    }
                    val tag = if(newFragment is CounterFragment) "counter" else "blank"
                    tr.replace(R.id.containerLayout, newFragment, tag)
                        .addToBackStack(null).commit()
                }
            }

            R.id.btnHide-> {
                if(fragment != null) {
                    if(fragment.isHidden)
                        tr.show(fragment).commit()
                    else
                        tr.hide(fragment).commit()
                }
            }
        }
    }
}
