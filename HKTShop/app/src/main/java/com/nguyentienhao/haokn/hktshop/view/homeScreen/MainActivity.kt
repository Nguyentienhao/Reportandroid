package com.nguyentienhao.haokn.hktshop.view.homeScreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.view.home.HomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            try {
                Thread.sleep(1000)
            }catch (e: Exception){
                Log.d("error", e.toString())
            }finally {
                val intentHome = Intent(this, HomeActivity::class.java)
                startActivity(intentHome)
            }
        }).start()
    }
}
