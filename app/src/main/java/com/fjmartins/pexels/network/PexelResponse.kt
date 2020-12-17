package com.fjmartins.pexels.network

import com.fjmartins.pexels.model.Photo

data class PexelResponse(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>,
    val total_results: Int
)
