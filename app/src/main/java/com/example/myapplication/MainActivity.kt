package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStart.setOnClickListener(this)
        buttonStop.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            buttonStart -> startClick()
            buttonStop -> stopClick()
        }
    }

    private fun stopClick() {
        Toast.makeText(applicationContext, "Stop", Toast.LENGTH_SHORT).show()
    }

    private fun startClick() {
        Toast.makeText(applicationContext, "Start", Toast.LENGTH_SHORT).show()
    }

}
