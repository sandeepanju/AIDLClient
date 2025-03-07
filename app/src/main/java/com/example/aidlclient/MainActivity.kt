package com.example.aidlclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aidlserver.DummyUser
import com.example.aidlserver.IAidlColourInterface


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityyyy"
    var aidl: IAidlColourInterface? = null

    val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            aidl = IAidlColourInterface.Stub.asInterface(binder)
            Log.d(TAG, "service connected")

            Log.d(
                "TAGGGGGGGG",
                "onServiceConnected: ${
                    aidl?.transformation(
                        DummyUser(
                            name = "Sandy--",
                            age = 24
                        )
                    )
                }"
            )
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidl = null
            Log.d(TAG, "service onServiceDisconnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent("com.example.aidlserver.IAidlColourInterface")
        intent.setPackage("com.example.aidlserver")
        bindService(intent, mConnection, BIND_AUTO_CREATE)
        Log.d(TAG, "bindservice called")
        changeColourOnButtonCLick()
    }

    private fun changeColourOnButtonCLick() {
        val button: Button = findViewById(R.id.buttonAidl)
        button.setOnClickListener {
            try {
                button.setBackgroundColor(aidl!!.colour)
            } catch (e: Exception) {
                Log.d(TAG, e.toString())
            }
        }
    }

    override fun onDestroy() {
        unbindService(mConnection)
        super.onDestroy()
    }
}