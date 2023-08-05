package com.example.fcis.models

import com.google.gson.annotations.SerializedName

data class StaffModel(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("branch") val branch: String,
    @SerializedName("contact") val contact: String,
    @SerializedName("staff_type") val staffType: Int,
    @SerializedName("lunch_time_start") val lunchTimeStart: String?,
    @SerializedName("lunch_duration_minutes") val lunchDurationMinutes: Int?
)
