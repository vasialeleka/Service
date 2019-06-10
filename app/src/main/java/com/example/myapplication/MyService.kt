package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

class MyService : Service() {
    var start = "hello"
    var finish = "bye"
    lateinit var data: String

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Servise", "Command start")
        data = intent!!.getStringExtra("data")
        var intent = Intent("ExtraData")
        intent.putExtra("String", start)
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("Servise", "Servise stop")
        var intent = Intent("ExtraData")

        intent.putExtra("String", finish )
        intent.putExtra("dataFrom", data)
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
        super.onDestroy()
    }

}