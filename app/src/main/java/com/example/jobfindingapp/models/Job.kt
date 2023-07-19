package com.example.jobfindingapp.models

import androidx.annotation.DrawableRes

data class Job(
    val title: String,
    val city: String,
    val town: String,
    val postedDate: String,
    val jobTime: String,
    val rating: String,
    val salary: String,
    val companyName: String,
    val aboutCompany: String,
    val aboutJob: String,
    val description: String,
    @DrawableRes val icon: Int,
)