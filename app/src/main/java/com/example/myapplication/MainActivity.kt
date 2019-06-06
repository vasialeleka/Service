package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var intentServise: Intent
    lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStart.setOnClickListener(this)
        buttonStop.setOnClickListener(this)
        intentServise = Intent(this, MyService::class.java)
        br = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                text.text = intent!!.getStringExtra("String")
            }

        }
        LocalBroadcastManager.getInstance(applicationContext)
                .registerReceiver(br, IntentFilter("ExtraData"))
    }

    override fun onClick(v: View?) {
        when (v) {
            buttonStart -> startClick()
            buttonStop -> stopClick()
        }
    }

    private fun stopClick() {
        Toast.makeText(applicationContext, "Stop", Toast.LENGTH_SHORT).show()
        stopService(intentServise)
    }

    private fun startClick() {
        Toast.makeText(applicationContext, "Start", Toast.LENGTH_SHORT).show()
        startService(intentServise)

    }

}
