package com.example.fcis.models

import com.google.gson.annotations.SerializedName

data class StaffModel(
    @SerializedName("name") val name: String,
    @SerializedName("username") val staffId: String?,
    @SerializedName("password") val password: String,
    @SerializedName("branch") val branch: String,
    @SerializedName("contact") val contact: String = "",
    @SerializedName("role_type") val roleType: Int
)
