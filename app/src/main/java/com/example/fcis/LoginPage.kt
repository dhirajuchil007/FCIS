package com.example.fcis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.fcis.api.Repo

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


    fun btnLogIn(view: View) {
        val Message = findViewById<TextView>(R.id.messageTextBox)
        val StaffId = findViewById<EditText>(R.id.staffIdTab).text.toString()
        val Password = findViewById<EditText>(R.id.passwordTab).text.toString()

        if (StaffId.isEmpty() || Password.isEmpty())
            Toast.makeText( this, "Please enter your Staff ID and Password",Toast.LENGTH_LONG).show()

        Repo.loginUser(StaffId, Password)
        }


            val btnLogin = findViewById<Button>(R.id.buttonLogIn)
            btnLogin.setOnClickListener {
                val Intent = Intent(this, HomePage::class.java)
                startActivity(Intent)

            }

        }

   fun btnSignIn (view: View) {
         val btnSignIn= findViewById<Button>(R.id.buttonSignInOptions)
       btnSignIn.setOnClickListener {
           val Intent = Intent(this, SignInOptionsPage::class.java)
           startActivity(Intent)
       }
   }

   fun btnForgetPassword(view : View) {
       val btnForgetPassword = findViewById<Button>(R.id.buttonForgotPassword)
       btnForgetPassword.setOnClickListener {
           val Intent = Intent(this, ForgotPasswordPage::class.java)
           startActivity(Intent)
       }



   }


    }

