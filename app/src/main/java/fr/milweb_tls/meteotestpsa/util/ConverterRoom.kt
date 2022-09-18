package fr.milweb_tls.meteotestpsa.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.milweb_tls.meteotestpsa.entities.Weather
import java.util.*

class ConverterRoom {

    // Convert Hourly object
    @TypeConverter
    fun toWeather(obj: String?): Weather? {
        val gson = Gson()
        val type = object : TypeToken<Weather?>() {}.type
        return gson.fromJson(obj, type)
    }
    @TypeConverter
    fun whetherToString(obj: Weather?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }



    // concert Date
    @TypeConverter
    fun toDate(date: Long?): Date? {
        return if (date == null) null else Date(date)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }


}