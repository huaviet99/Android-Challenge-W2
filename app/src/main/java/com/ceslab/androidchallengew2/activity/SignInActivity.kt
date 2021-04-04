package com.ceslab.androidchallengew2.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ceslab.androidchallengew1.model.User
import com.ceslab.androidchallengew2.R
import com.google.android.material.button.MaterialButton

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_sign_in)
        val user: User = User()
        var edtEmail = findViewById<EditText>(R.id.edt_email)
        var edtPassword = findViewById<EditText>(R.id.edt_password)
        val btnSignIn = findViewById<MaterialButton>(R.id.btn_sign_in)
        btnSignIn.setOnClickListener {
            if (edtEmail.text.toString().trim() == user.email && edtPassword.text.toString().trim() == user.password) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@SignInActivity, "Sign in fail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}