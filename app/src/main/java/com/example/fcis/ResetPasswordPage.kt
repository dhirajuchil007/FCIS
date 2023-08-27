package com.example.fcis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ResetPasswordPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password_page)
    }

    fun ResetPasswordbtn(view: View) {

        val resetPwd = findViewById<Button>(R.id.buttonResetPassword)
        resetPwd.setOnClickListener {
            val Intent = Intent(this, HomePage::class.java)
            startActivity(Intent)

        }


    }






}