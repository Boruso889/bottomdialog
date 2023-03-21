package com.example.madskills

import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {



    @GET("api/catalog")
    fun getCatlog(): Call<ArrayList<CatlogClass>>

}