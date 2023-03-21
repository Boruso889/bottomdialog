package com.example.madskills

import com.google.gson.annotations.SerializedName

data class CatlogClass(
    @SerializedName("id")
    val catlogid: Int,

    @SerializedName("name")
    val catlogname: String,

    @SerializedName("description")
    val catlogdesc: String,

    @SerializedName("price")
    val catlogprice: Float,

    @SerializedName("category")
    val catlogcat: String,

    @SerializedName("time_result")
    val catlogtime: String,

    @SerializedName("preparation")
    val catlogprep: String,

    @SerializedName("bio")
    val catlogbio: String






)


