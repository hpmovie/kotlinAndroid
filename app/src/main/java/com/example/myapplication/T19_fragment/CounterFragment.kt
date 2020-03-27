package com.example.myapplication.T19_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_counter2.*

/**
 * A simple [Fragment] subclass.
 */
class CounterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_counter2, container, false)
        val btnIncrease = v.findViewById<Button>(R.id.btnIncrease)
        val tvCounter = v.findViewById<TextView>(R.id.tvCounter)
        btnIncrease.setOnClickListener{
            val value = tvCounter.text.toString().toInt()
            tvCounter.text = "${value+1}"
        }
        return v
    }

}
