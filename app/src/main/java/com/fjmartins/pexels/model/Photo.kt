package com.fjmartins.pexels.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "avg_color")
    val avg_color: String,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "liked")
    val liked: Boolean,
    @ColumnInfo(name = "photographer")
    val photographer: String,
    @ColumnInfo(name = "photographer_id")
    val photographer_id: Int,
    @ColumnInfo(name = "photographer_url")
    val photographer_url: String,
    @ColumnInfo(name = "src")
    val src: Src,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "width")
    val width: Int,
    @ColumnInfo(name = "keyword")
    var keyword: String
)