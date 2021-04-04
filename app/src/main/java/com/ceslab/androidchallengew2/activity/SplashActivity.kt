package com.ceslab.androidchallengew2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this,
            BoardingOneActivity::class.java)
        startActivity(intent)
    }
}