package com.example.fcis

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SignInOptionsPage : AppCompatActivity() {

    // 1 button
    var signUp: Button? = null

    // 3 texts fields
    var fullName: EditText? = null
    var roleType: EditText? = null
    var password: EditText? = null
    var branchType : TextView? = null
    var txtSignIn: TextView? = null
    var email: EditText? = null
    var confPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_options_page)

        fullName=findViewById(R.id.edtSignUpFullName)
        roleType =findViewById(R.id.edtSignUpFullName)
        branchType =findViewById(R.id.edtSignUpFullName)
        email =findViewById(R.id.edtSignUpEmail)
        password =findViewById(R.id.edtSignUpPassword)
        confPassword=findViewById(R.id.edtSignUpConfirmPassword)
        txtSignIn = findViewById<TextView>(R.id.txtSignIn)

                txtSignIn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@activity_sign_in_options_page, LoginPage::class.java)
            startActivity(intent)
            finish()

    })
  }
}

