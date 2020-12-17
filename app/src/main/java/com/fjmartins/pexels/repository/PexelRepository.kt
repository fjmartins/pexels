package com.fjmartins.pexels.repository

import com.fjmartins.pexels.dao.PexelDatabase
import com.fjmartins.pexels.network.PexelApi
import com.fjmartins.pexels.network.PexelResponse

class PexelRepository(
    private val pexelDatabase: PexelDatabase,
    private val pexelApi: PexelApi
) {
    suspend fun getImages(query: String): PexelResponse? {
        return try {
            pexelApi.getImages(query, 1)
        } catch (e: Exception) {
            return null
        }
    }
}