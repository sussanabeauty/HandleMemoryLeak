package org.sussanacode.memoryleakprofiledemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AlertDialog
import org.sussanacode.memoryleakprofiledemo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnshow.setOnClickListener {
            showMessage()
            handler.sendEmptyMessageDelayed(0, 3000)
        }
    }

    val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val intent = Intent(baseContext, ProfilerActivity::class.java )
            startActivity(intent)
            finish()
        }

    }


    private fun showMessage(){
        val list = ArrayList<Int>()
        val t = object : Thread(){

            override fun run() {
                super.run()

                for (i in 1..1000000){
                    val n = Random.nextInt(50000)
                    list.add(n)
                    Thread.sleep(1000)
                }
            }
        }
        t.start()

       val dialog =  AlertDialog.Builder(this)
           .setMessage("Hello")
           .setTitle("Message").create()

        dialog.show()
    }

    val receiver = object: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
        }

    }
}