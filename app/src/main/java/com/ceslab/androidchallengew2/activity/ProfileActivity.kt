package com.ceslab.androidchallengew2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.ceslab.androidchallengew2.R
import com.ceslab.androidchallengew2.model.User

class ProfileActivity : AppCompatActivity() {
    private val TAG = "ProfileActivity"
    lateinit var tvFullName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhoneNumber: TextView
    lateinit var edEditInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_profile)
        findViewById()
        onGetUser()
        editInfo()
    }

    private fun onGetUser() {
        Log.d(TAG, "onGetUser: ")
        val bundle = intent.extras
        bundle?.let {
            val user = bundle.getParcelable<User>("USER")
            initInfo(user)
        }
    }

    private fun findViewById() {
        Log.d(TAG, "findViewById: ")
        tvFullName = findViewById<TextView>(R.id.tv_full_name)
        tvEmail = findViewById<TextView>(R.id.tv_email)
        tvPhoneNumber = findViewById<TextView>(R.id.tv_phone_number)
    }

    private fun initInfo(user: User?) {
        Log.d(TAG, "initInfo: ")
        tvFullName.text = user?.fullName
        tvEmail.text = user?.email
        tvPhoneNumber.text = user?.phoneNumber
    }

    private fun onInputAlerDiaLog(
        title: String,
        textHint: String,
        textView: TextView
    ) {
        Log.d(TAG, "onInputAlerDiaLog: ")
        val view: View = LayoutInflater
            .from(this)
            .inflate(R.layout.layout_input_alerdialog, null, false)
        edEditInput = view.findViewById(R.id.ed_input)
        edEditInput.setText(textView.text)
        edEditInput.setHint(textHint)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setView(view)
            .setTitle(title)
            .setPositiveButton("OK") { dialog, which ->
                Log.d(TAG, "onInputAlerDiaLog: " + edEditInput.text)
                textView.text = edEditInput.text
                dialog.dismiss()
            }
            .setNegativeButton("CANCEL") { dialog, which ->
                Log.d(TAG, "onInputAlerDiaLog:CANCEL ")
                dialog.dismiss()
            }.show()

    }

    private fun editInfo() {
        Log.d(TAG, "editInfo: ")
        tvFullName.setOnClickListener {
            onInputAlerDiaLog(
                "Edit Full Name",
                "Enter your full name",
                tvFullName
            )
        }

        // Edit email

        tvEmail.setOnClickListener {
            onInputAlerDiaLog(
                "Edit E-mail ",
                "Enter your e-mail",
                tvEmail
            )
        }

        // Edit Phone number
        tvPhoneNumber.setOnClickListener {
            onInputAlerDiaLog(
                "Edit Phone Number ",
                "Enter your phone number",
                tvPhoneNumber
            )
        }
    }
}