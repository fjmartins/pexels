package com.fjmartins.pexels.repository

import com.fjmartins.pexels.dao.PexelDatabase
import com.fjmartins.pexels.model.Photo
import com.fjmartins.pexels.network.PexelApi
import java.net.UnknownHostException

class PexelRepository(
    private val pexelDatabase: PexelDatabase,
    private val pexelApi: PexelApi
) {
    suspend fun getImages(query: String): List<Photo>? {
        return try {
            val response = pexelApi.getImages(query, 1)

            response.photos.map { photo ->
                photo.keyword = query
            }

            pexelDatabase
                .photosDao()
                .insertPhotos(response.photos)

            response.photos
        } catch (e: UnknownHostException) { // Load from cache
            pexelDatabase
                .photosDao()
                .getPhotos(query)
        }
    }
}