package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlin (

    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("statusCode") var statusCode: Int?     = null,
    @SerializedName("message") var message: String?  = null,
    @SerializedName("support_whatsapp_number" ) var supportWhatsappNumber : String?  = null,
    @SerializedName("extra_income") var extraIncome : Double?  = null,
    @SerializedName("total_links") var totalLinks : Int?     = null,
    @SerializedName("total_clicks") var totalClicks: Int?     = null,
    @SerializedName("today_clicks"            ) var todayClicks           : Int?     = null,
    @SerializedName("top_source"              ) var topSource             : String?  = null,
    @SerializedName("top_location"            ) var topLocation           : String?  = null,
    @SerializedName("startTime"               ) var startTime             : String?  = null,
    @SerializedName("links_created_today"     ) var linksCreatedToday     : Int?     = null,
    @SerializedName("applied_campaign"        ) var appliedCampaign       : Int?     = null,
    @SerializedName("data") var data: Data?    = Data()

)

data class RecentLinks (

    @SerializedName("url_id") var urlId         : Int?    = null,
    @SerializedName("web_link") var webLink       : String? = null,
    @SerializedName("smart_link") var smartLink     : String? = null,
    @SerializedName("title"          ) var title         : String? = null,
    @SerializedName("total_clicks"   ) var totalClicks   : Int?    = null,
    @SerializedName("original_image" ) var originalImage : String? = null,
    @SerializedName("thumbnail"      ) var thumbnail     : String? = null,
    @SerializedName("times_ago"      ) var timesAgo      : String? = null,
    @SerializedName("created_at"     ) var createdAt     : String? = null,
    @SerializedName("domain_id"      ) var domainId      : String? = null,
    @SerializedName("url_prefix"     ) var urlPrefix     : String? = null,
    @SerializedName("url_suffix"     ) var urlSuffix     : String? = null,
    @SerializedName("app"            ) var app           : String? = null

)

data class TopLinks (

    @SerializedName("url_id"         ) var urlId         : Int?    = null,
    @SerializedName("web_link"       ) var webLink       : String? = null,
    @SerializedName("smart_link"     ) var smartLink     : String? = null,
    @SerializedName("title"          ) var title         : String? = null,
    @SerializedName("total_clicks"   ) var totalClicks   : Int?    = null,
    @SerializedName("original_image" ) var originalImage : String? = null,
    @SerializedName("thumbnail"      ) var thumbnail     : String? = null,
    @SerializedName("times_ago"      ) var timesAgo      : String? = null,
    @SerializedName("created_at"     ) var createdAt     : String? = null,
    @SerializedName("domain_id"      ) var domainId      : String? = null,
    @SerializedName("url_prefix"     ) var urlPrefix     : String? = null,
    @SerializedName("url_suffix"     ) var urlSuffix     : String? = null,
    @SerializedName("app"            ) var app           : String? = null

)

data class OverallUrlChart (
@SerializedName("2023-04-14" ) var day2  : Int = 0,
@SerializedName("2023-04-15" ) var day3  : Int = 0,
@SerializedName("2023-04-16" ) var day4  : Int = 0,
@SerializedName("2023-04-17" ) var day5  : Int = 0,
@SerializedName("2023-04-18" ) var day6  : Int = 0,
@SerializedName("2023-04-19" ) var day7 : Int = 0,
@SerializedName("2023-04-20" ) var day8  : Int = 0,
@SerializedName("2023-04-21" ) var day9  : Int = 0,
@SerializedName("2023-04-22" ) var day10  : Int = 0,
    @SerializedName("2023-04-23" ) var day11 : Int = 0,
    @SerializedName("2023-04-24" ) var day12  : Int = 0,
    @SerializedName("2023-04-25" ) var day13  : Int = 0,
    @SerializedName("2023-04-26" ) var day14  : Int = 0,
    @SerializedName("2023-04-27" ) var day15  : Int = 0,
    @SerializedName("2023-04-28" ) var day16  : Int = 0,
    @SerializedName("2023-04-29" ) var day17 : Int = 0,
    @SerializedName("2023-04-30" ) var day18  : Int = 0,
    @SerializedName("2023-05-01" ) var day19  : Int = 0,
    @SerializedName("2023-05-02" ) var day20  : Int = 0,
    @SerializedName("2023-05-03" ) var day21 : Int = 0,
    @SerializedName("2023-05-04" ) var day22  : Int = 0,
    @SerializedName("2023-05-05" ) var day23  : Int = 0,
    @SerializedName("2023-05-06" ) var day24  : Int = 0,
    @SerializedName("2023-05-07" ) var day25  : Int = 0,
    @SerializedName("2023-05-08" ) var day26  : Int = 0,
    @SerializedName("2023-05-09" ) var day27 : Int = 0,
    @SerializedName("2023-05-10" ) var day28  : Int = 0,
    @SerializedName("2023-05-11" ) var day29  : Int = 0,
    @SerializedName("2023-05-12" ) var day30  : Int = 0,
    @SerializedName("2023-05-13" ) var day31  : Int = 0,
    @SerializedName("2023-05-14" ) var day32  : Int = 0,



)

data class Data (

    @SerializedName("recent_links"      ) var recentLinks     : ArrayList<TopLinks> = arrayListOf(),
    @SerializedName("top_links"         ) var topLinks        : ArrayList<TopLinks>    = arrayListOf(),
    @SerializedName("overall_url_chart" ) var overallUrlChart : OverallUrlChart?       = OverallUrlChart()

)




