package com.example.fcis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fcis.api.Repo
import com.example.fcis.models.StaffModel
import com.skydoves.powerspinner.PowerSpinnerView


class SignInOptionsPage : AppCompatActivity(), OnItemSelectedListener {

    companion object {
        val roleTypes = hashMapOf<String, Int>(
            "Administrator" to 1,
            "Manager" to 2,
            "Receptionist" to 3,
            "Universal Banker" to 4
        )
    }

    // 1 button

    // 7 texts fields
    var staffId: EditText? = null
    var fullName: EditText? = null
    var password: EditText? = null
    var txtSignIn: TextView? = null
    var email: EditText? = null
    var confPassword: EditText? = null
    var btnSignUp: Button? = null
    var branchSpinner: PowerSpinnerView? = null
    var roleTypeSpinner: PowerSpinnerView? = null
    var progressView: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_options_page)

        branchSpinner = findViewById(R.id.branchSpinner)
        roleTypeSpinner = findViewById(R.id.roleTypeSpinner)
        progressView = findViewById(R.id.signUpProgressBar)
        staffId = findViewById(R.id.edtStaffId)
        fullName = findViewById(R.id.edtSignUpFullName)
        email = findViewById(R.id.edtSignUpEmail)
        password = findViewById(R.id.edtSignUpPassword)
        confPassword = findViewById(R.id.edtSignUpConfirmPassword)
        txtSignIn = findViewById(R.id.txtSignIn)
        btnSignUp = findViewById(R.id.buttonSignUp)

        txtSignIn?.setOnClickListener(View.OnClickListener {
            goToLoginPage()

        })

        btnSignUp?.setOnClickListener {
            if (validateFields()) {
                val staffModel = StaffModel(
                    name = fullName!!.text.toString(),
                    password = password!!.text.toString(),
                    branch = getValueFromSpinner(branchSpinner, R.array.branch),
                    roleType = roleTypes.get(
                        getValueFromSpinner(
                            roleTypeSpinner,
                            R.array.role_type
                        )
                    )!!,
                    staffId = staffId!!.text.toString()
                )

                btnSignUp?.visibility = View.GONE
                progressView?.visibility = View.VISIBLE
                Repo.createStaff(staffModel) { result, isSuccessful ->
                    if (isSuccessful) {
                        Toast.makeText(this@SignInOptionsPage, "User created", Toast.LENGTH_LONG)
                            .show()
                        goToLoginPage()
                    } else {
                        btnSignUp?.visibility = View.VISIBLE
                        progressView?.visibility = View.GONE
                        showErrorDialog(this@SignInOptionsPage, "User creation failed")
                    }
                }
            } else {

            }
        }


    }

    private fun goToLoginPage() {
        val intent = Intent(this@SignInOptionsPage, LoginPage::class.java)
        startActivity(intent)
        finish()
    }

    private fun getValueFromSpinner(spinner: PowerSpinnerView?, array: Int): String {
        val array = resources.getStringArray(array)
        return array[spinner!!.selectedIndex]
    }

    private fun validateFields(): Boolean {

        if (staffId?.text.toString().isNullOrEmpty()) {
            showError(staffId, "Need staff id to proceed")
            return false
        }

        if (fullName?.text.toString().isNullOrEmpty()) {
            showError(fullName, "Enter full name")
            return false
        }

        if (email?.text.toString().isNullOrEmpty()) {
            showError(email, "Enter Email")
            return false
        }

        if (password?.text.toString().isNullOrEmpty()) {
            showError(password, "Enter password")
            return false
        }

        if (confPassword?.text.toString()
                .isNullOrEmpty() || confPassword?.text.toString() != password?.text.toString()
        ) {
            showError(confPassword, "Passwords do not match")
            return false
        }

        if (branchSpinner?.selectedIndex == -1) {
            branchSpinner?.error = "Select branch"
            branchSpinner?.requestFocus()
            return false
        }
        if (roleTypeSpinner?.selectedIndex == -1) {
            roleTypeSpinner?.error = "Select role"
            roleTypeSpinner?.requestFocus()
            return false
        }
        return true
    }

    private fun showError(editText: EditText?, error: String) {
        editText?.error = error
        editText?.requestFocus()
    }

    private fun clearError(editText: EditText?) {
        editText?.error = null
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


    fun showErrorDialog(context: Context, message: String) {
        val alertDialog: AlertDialog = AlertDialog.Builder(context)
            .setTitle("Alert")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                // Code to execute when the "OK" button is clicked
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }

}

