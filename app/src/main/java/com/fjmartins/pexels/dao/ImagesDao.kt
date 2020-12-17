package com.fjmartins.pexels.dao

import androidx.room.*
import com.fjmartins.pexels.model.Image
import io.reactivex.Single

@Dao
interface ImagesDao {

    @Query("SELECT * FROM images")
    fun getAllImages(): Single<List<Image>>

    @Insert
    fun insertPhoto(currency: Image): Single<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(currencies: List<Image>): Single<List<Long>>

    @Query("SELECT * FROM images WHERE keyword=:keyword")
    fun getCurrency(keyword: String): Single<Image>

    @Update
    fun updateCurrency(currencies: Image): Single<Int>

    @Delete
    fun deleteCurrency(currencies: Image): Single<Int>

    @Query("DELETE FROM images")
    fun deleteAll(): Single<Int>
}