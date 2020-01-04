package com.lina.contohpariwisatayogyakarta

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        handler= Handler()
        handler.postDelayed(Runnable { var intent: Intent
        intent= Intent(this@Splash, MainActivity::class.java)
           startActivity(intent)
            this@Splash.finish()}, 2000)
    }
}
