package com.ceslab.androidchallengew2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ceslab.androidchallengew1.model.User
import com.ceslab.androidchallengew2.R

class ProfileActivity : AppCompatActivity() {
    private val TAG = "ProfileActivity"
    lateinit var tvFullName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhoneNumber: TextView
    var user: User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById()
        initInfo()
        editInfo()
    }

    private fun findViewById() {
        tvFullName = findViewById<TextView>(R.id.tv_full_name)
        tvEmail = findViewById<TextView>(R.id.tv_email)
        tvPhoneNumber = findViewById<TextView>(R.id.tv_phone_number)
    }

    private fun initInfo() {
        tvFullName.text = user.fullName
        tvEmail.text = user.email
        tvPhoneNumber.text = user.phoneNumber
    }

    private fun editInfo() {
        tvFullName.setOnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ProfileActivity)
            alertDialog.setTitle("Full name")
            alertDialog.setMessage("Enter your full name")
            var editText: EditText = EditText(this);
            var linearParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
            );
            editText.setBackgroundResource(R.drawable.border_outline_textview)
            editText.layoutParams = linearParams
            alertDialog.setView(editText)
            alertDialog.setPositiveButton("YES") { dialog, which ->
                tvFullName.text = editText.text
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }
            alertDialog.show();
        }

        // Edit email

        tvEmail.setOnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ProfileActivity)
            alertDialog.setTitle("E-mail")
            alertDialog.setMessage("Enter your email")
            var editText: EditText = EditText(this);
            var linearParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
            );
            editText.setBackgroundResource(R.drawable.border_outline_textview)
            editText.layoutParams = linearParams
            alertDialog.setView(editText)
            alertDialog.setPositiveButton("OK") { dialog, which ->
                tvEmail.text = editText.text
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }
            alertDialog.show();
        }

        // Edit Phone number
        tvPhoneNumber.setOnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ProfileActivity)
            alertDialog.setTitle("Phone number")
            alertDialog.setMessage("Enter your phone number")
            var editText: EditText = EditText(this);
            var linearParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
            );
            editText.setBackgroundResource(R.drawable.border_outline_textview)
            editText.layoutParams = linearParams
            alertDialog.setView(editText)
            alertDialog.setPositiveButton("YES") { dialog, which ->
                if (editText.text.toString().trim().length === 10) {
                    tvPhoneNumber.text = editText.text
                    user.phoneNumber = editText.text.toString().trim()
                    dialog.dismiss()
                } else {
                    Toast.makeText(this@ProfileActivity, "Invalid phone number", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            alertDialog.setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }
            alertDialog.show();
        }
    }
}