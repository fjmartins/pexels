package com.fjmartins.pexels.dao

import androidx.room.*
import com.fjmartins.pexels.model.Photo

@Dao
interface PhotosDao {
    @Query("SELECT * FROM photos")
    suspend fun getAllPhotos(): List<Photo>

    @Insert
    suspend fun insertPhoto(photo: Photo): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos: List<Photo>): List<Long>

    @Query("SELECT * FROM photos WHERE keyword=:keyword")
    suspend fun getPhotos(keyword: String): List<Photo>

    @Update
    suspend fun updatePhoto(photo: Photo): Int

    @Delete
    suspend fun deletePhoto(photo: Photo): Int

    @Query("DELETE FROM photos")
    suspend fun deleteAll(): Int
}