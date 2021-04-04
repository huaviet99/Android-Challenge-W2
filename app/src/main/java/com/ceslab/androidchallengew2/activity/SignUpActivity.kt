package com.ceslab.androidchallengew2.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ceslab.androidchallengew2.R
import com.google.android.material.button.MaterialButton

/**
 * Created by Viet Hua on 04/03/2021.
 */

class SignUpActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_sign_up)


        val btnSignup = findViewById<MaterialButton>(R.id.btn_sign_up)
        btnSignup.setOnClickListener {
            val intent = Intent(this,
                SignInActivity::class.java)
            startActivity(intent)
        }
    }
}