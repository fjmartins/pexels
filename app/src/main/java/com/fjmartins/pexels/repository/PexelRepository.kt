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
            val response = pexelApi.getImages(query, 1)

            response.photos.map {photo ->
                photo.keyword = query
            }

            pexelDatabase
                .photosDao()
                .insertPhotos(response.photos)

            response
        } catch (e: Exception) {
            null
        }
    }
}