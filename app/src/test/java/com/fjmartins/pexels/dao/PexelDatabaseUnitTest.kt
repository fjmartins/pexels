package com.fjmartins.pexels.dao

import androidx.room.Room
import com.fjmartins.pexels.base.BaseUnitTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PexelDatabaseUnitTest : BaseUnitTest() {

    private var photosDao: PhotosDao? = null
    private lateinit var database : PexelDatabase

    @Before
    fun initializeDb() {
        database = Room.databaseBuilder(
            context,
            PexelDatabase::class.java, "test-database"
        ).build()

        photosDao = database.photosDao()
    }

    @Test
    fun databaseInitializedSuccessfully() {
        assertEquals(true, photosDao != null)
    }

    @After
    fun closeDb() {
        database.close()
    }
}