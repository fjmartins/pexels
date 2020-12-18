package com.fjmartins.pexels.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fjmartins.pexels.model.Photo
import com.fjmartins.pexels.model.SrcConverter

@Database(entities = [Photo::class], version = 1)
@TypeConverters(SrcConverter::class)
abstract class PexelDatabase: RoomDatabase() {
    abstract fun photosDao(): PhotosDao
}