package com.example.jobfindingapp.models

import androidx.annotation.DrawableRes

data class Job(
    val title: String,
    val location: String,
    val postedDate: String,
    val jobTime: String,
    val rating: String,
    @DrawableRes val icon: Int,
)
