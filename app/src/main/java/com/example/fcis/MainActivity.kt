package com.example.fcis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    fun btnLogin(view: View) {
        val Message = findViewById<TextView>(R.id.textViewMessage)
        val Username = findViewById<EditText>(R.id.etUsername).text.toString()
        val Password = findViewById<EditText>(R.id.etPassword).text.toString()


            val btnLogin = findViewById<Button>(R.id.btnLogin)
            btnLogin.setOnClickListener {
                val Intent = Intent(this, HomePage::class.java)
                startActivity(Intent)
            }
            if (Username != Password)
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_LONG).show()

        }

   fun btn_Sign_in_Options(view: View) {
       val btn_Sign_in_Options = findViewById<Button>(R.id.btn_Sign_in_Options)
       btn_Sign_in_Options.setOnClickListener {
           val Intent = Intent(this, Sign_in_options::class.java)
           startActivity(Intent)
       }
   }
    }
}
