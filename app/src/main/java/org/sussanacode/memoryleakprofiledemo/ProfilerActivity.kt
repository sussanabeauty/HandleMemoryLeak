package org.sussanacode.memoryleakprofiledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfilerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiler)
    }
}