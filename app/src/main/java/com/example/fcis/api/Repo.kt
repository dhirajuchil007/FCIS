package com.example.fcis.api

import com.example.fcis.models.StaffModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repo {

    val apiService = ApiClient.getClient().create(ApiService::class.java)

    fun loginFake(username: String, pwd: String): Boolean {
        return true
    }

     fun loginUser(username: String, pwd: String) {
         val call = apiService.login(username, pwd)

         call.enqueue(object : Callback<StaffModel> {
             override fun onResponse(call: Call<StaffModel>, response: Response<StaffModel>) {
                 TODO("Not yet implemented")
             }

             override fun onFailure(call: Call<StaffModel>, t: Throwable) {
                 TODO("Not yet implemented")
             }

         })
     }
}