package com.fjmartins.pexels.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class Image (
    @ColumnInfo(name = "author")
    var author: String = "",
    @ColumnInfo(name = "keyword")
    val keyword: String = "",

    @PrimaryKey
    @ColumnInfo(name = "url")
    var url: String = ""
)