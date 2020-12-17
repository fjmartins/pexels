package com.fjmartins.pexels.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SrcConverter {

    /**
     * Convert Src object to a Json
     */
    @TypeConverter
    fun toJson(src: Src): String {
        return Gson().toJson(src)
    }

    /**
     * Convert a json to a Src object
     */
    @TypeConverter
    fun toSrcObject(jsonImages: String): Src {
        val srcType = object : TypeToken<Src>() {}.type
        return Gson().fromJson(jsonImages, srcType)
    }

}