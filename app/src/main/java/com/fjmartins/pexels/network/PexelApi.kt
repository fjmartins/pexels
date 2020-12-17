package com.fjmartins.pexels.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PexelApi {
    companion object {
        const val KEY = "563492ad6f9170000100000187388c1f514c47aaa7825edc9bdefdfd"
        const val URL = "https://api.pexels.com/v1/"
    }

    @GET("search")
    suspend fun getImages(@Query("query") query: String, @Query("page") page: Int, @Query("per_page") perPage: Int = 20): PexelResponse
}