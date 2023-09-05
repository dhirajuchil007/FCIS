package com.example.fcis

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SignInOptionsPage : AppCompatActivity() {

    // 1 button
    var signUp: Button? = null

    // 7 texts fields
    var fullName: EditText? = null
    var password: EditText? = null
    var branchType : TextView? = null
    var txtSignIn: TextView? = null
    var email: EditText? = null
    var confPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_options_page)

        val roleType_spinner = findViewById<Spinner>(R.id.roleTypeSpinner)
        val arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.role_type,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItenSelectListener = this

    override fun onItemSelected(parent: adapterView<*>?, view: View?, position:int, id:Long) {
         val text= adapterView?.getItemAtPosition(position).toString ()     }
    override fun onNothingSelected(parent: AdapterView<*>? ){
        TODO("Not yet implemented")
    }


        fullName=findViewById(R.id.edtSignUpFullName)
        branchType =findViewById(R.id.edtSignUpFullName)
        email =findViewById(R.id.edtSignUpEmail)
        password =findViewById(R.id.edtSignUpPassword)
        confPassword=findViewById(R.id.edtSignUpConfirmPassword)
        txtSignIn = findViewById<TextView>(R.id.txtSignIn)

                txtSignIn?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignInOptionsPage, LoginPage::class.java)
            startActivity(intent)
            finish()

    })
  }
}

