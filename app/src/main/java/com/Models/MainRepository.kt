package com.Models

import com.velmurugan.mvvmretrofitrecyclerviewkotlin.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getPageData(): DashboardPageData {

        val list = arrayListOf<Any>()
        val data= DashboardPageData(list = list)
        val response=retrofitService.getAllMovies(auth = "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
        val cardData= CardResponseData(response.data?.topLinks!!,response?.data?.recentLinks!!)
        list.add(HeadingAndGraphData(response.data?.overallUrlChart!!))
        list.add(ClicksCardData(response.totalClicks?:0,response.topLocation?:"",response.topSource?:""))
        list.add(CommonData())
        list.add(cardData)
        list.add(CommonData(true))
        list.add(CommonButtonData())
        list.add(CommonButtonData(isForFaq = true))
        return data
    }
}