package com.fjmartins.pexels.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjmartins.pexels.model.Image

@Database(entities = [Image::class], version = 1)
abstract class PexelDatabase: RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}