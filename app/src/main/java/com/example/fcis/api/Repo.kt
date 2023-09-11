package com.example.fcis.api

import android.util.Log
import com.example.fcis.models.StaffModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repo {
    private const val TAG = "Repo"

    val apiService = ApiClient.getClient().create(ApiService::class.java)

    fun loginFake(staffID: String, pwd: String): Boolean {
        return true
    }

    fun loginUser(staffID: String, pwd: String, callback: (isSuccess: Boolean) -> Unit) {
        val call = apiService.login(staffID, pwd)

        call.enqueue(object : Callback<StaffModel> {
            override fun onResponse(call: Call<StaffModel>, response: Response<StaffModel>) {
                Log.d(TAG, "onResponse() called with: call = $call, response = $response")
                if (response.isSuccessful) {
                    callback.invoke(true)
                } else {
                    callback.invoke(false)
                }
            }

            override fun onFailure(call: Call<StaffModel>, t: Throwable) {
                Log.d(TAG, "onFailure() called with: call = $call, t = $t")
                callback.invoke(false)
            }

        })
    }


    fun createStaff(
        staffModel: StaffModel,
        callback: (result: String?, isSuccess: Boolean) -> Unit
    ) {
        val call = apiService.createStaff(staffModel)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful)
                    callback.invoke(response.body(), true)
                else
                    callback.invoke(null, false)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                callback.invoke(t.message?.toString(), false)
            }

        })

    }
}