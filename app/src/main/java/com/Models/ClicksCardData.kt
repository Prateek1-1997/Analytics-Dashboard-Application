package com.Models

import com.velmurugan.mvvmretrofitrecyclerviewkotlin.OverallUrlChart
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.TopLinks


data class ClicksCardData(
    val clicksCount:Int,
    val location:String?,
    val topSource:String?
)