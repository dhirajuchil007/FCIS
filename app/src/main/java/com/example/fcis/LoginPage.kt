package com.example.fcis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fcis.api.Repo

class LoginPage : AppCompatActivity() {

    /*getMyData(),

    private fun getMyData() {
    val retrofitBuilder = Retrofit.builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
    .create(ApiService::class.java)


     */

    // 3 buttons
    var loginBtn: Button? = null
    var fgttenPassword: TextView? = null
    var signInBtn: Button? = null

    // 3 texts fields
    var staffId: EditText? = null
    var password: EditText? = null
    var message: TextView? = null

    // boolean variable to check whether all the text fields are filled by the user, properly or not.
    var isAllFieldsChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_new)


        // register buttons and edit texts with their proper IDs.
        message = findViewById(R.id.messageTextBox)
        staffId = findViewById(R.id.staffIdTab)
        password = findViewById(R.id.passwordTab)
        loginBtn = findViewById(R.id.buttonLogIn)
        fgttenPassword = findViewById(R.id.buttonForgotPassword)
        signInBtn = findViewById(R.id.buttonSignInOptions)


        loginBtn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                message?.text = ""
                // store the returned value of the dedicated function which checks
                // whether the entered data is valid or if any fields are left blank.
                isAllFieldsChecked = CheckAllFields()

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Repo.loginUser(staffId?.text.toString(), password?.text.toString()) {
                        if (it) {
                            goToHomePage()
                            //  finish()
                        } else {
                            showError()
                        }
                    }
                }
            }
        })

        signInBtn?.setOnClickListener {
            startActivity(Intent(this@LoginPage, SignInOptionsPage::class.java))
        }

    }

    private fun showError() {
        //show alert username of password is incorrect
        message?.text = "Incorrect credentials"

    }

    private fun goToHomePage() {
        val i = Intent(this@LoginPage, HomePage::class.java)
        startActivity(i)
    }

    fun CheckAllFields(): Boolean {
        if (staffId?.length() == 0) {
            staffId!!.error = "This field is required"
            return false
        }
        if (password!!.length() == 0) {
            password!!.error = "Password is required"
            return false

        }

        // after all validation return true.
        return true
    }
}


// validation credential
// login user api response end
// success response -> home page/ failed dialog box