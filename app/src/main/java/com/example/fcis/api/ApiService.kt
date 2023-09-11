package com.example.fcis.api

import com.example.fcis.MyDataItem
import com.example.fcis.models.StaffModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    fun login(@Query("username") username: String, @Query("password") pwd: String): Call<StaffModel>

    /* @GET("posts")
     fun getData(): Call<List<MyDataItem>>*/

    @POST("/createStaff/")
    fun createStaff(@Body staffModel: StaffModel): Call<String>
}