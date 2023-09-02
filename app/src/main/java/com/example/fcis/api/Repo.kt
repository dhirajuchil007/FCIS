package com.example.fcis.api

import com.example.fcis.models.StaffModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repo {

    val apiService = ApiClient.getClient().create(ApiService::class.java)

    fun loginFake(staffID: String, pwd: String): Boolean {
        return true
    }

    fun loginUser(staffID: String, pwd: String, callback: (isSuccess: Boolean) -> Unit) {
        val call = apiService.login(staffID, pwd)

        call.enqueue(object : Callback<StaffModel> {
            override fun onResponse(call: Call<StaffModel>, response: Response<StaffModel>) {
                callback.invoke(true)
            }

            override fun onFailure(call: Call<StaffModel>, t: Throwable) {
                callback.invoke(false)
            }

        })
    }


    fun createStaff(staffModel: StaffModel, callback : (result : String?)->Unit){
        val call = apiService.createStaff(staffModel)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                callback.invoke(response.body()!!)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                callback.invoke(t.message?.toString())
            }

        })

    }
}