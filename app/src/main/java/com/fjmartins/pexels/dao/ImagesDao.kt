package com.fjmartins.pexels.dao

import androidx.room.*
import com.fjmartins.pexels.model.Image

@Dao
interface ImagesDao {

    @Query("SELECT * FROM images")
    fun getAllImages(): List<Image>

    @Insert
    fun insertPhoto(currency: Image): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(currencies: List<Image>): List<Long>

    @Query("SELECT * FROM images WHERE keyword=:keyword")
    fun getCurrency(keyword: String): Image

    @Update
    fun updateCurrency(currencies: Image): Int

    @Delete
    fun deleteCurrency(currencies: Image): Int

    @Query("DELETE FROM images")
    fun deleteAll(): Int
}