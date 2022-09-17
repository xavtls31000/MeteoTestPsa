package fr.milweb_tls.meteotestpsa.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.milweb_tls.meteotestpsa.entities.Current
import fr.milweb_tls.meteotestpsa.entities.Hourly
import fr.milweb_tls.meteotestpsa.entities.Weather
import java.util.*

class ConverterRoom {

    // Convert Current object
    @TypeConverter
    fun toCurrent(obj: String?): Current? {
        val gson = Gson()
        val type = object : TypeToken<Current?>() {}.type
        return gson.fromJson(obj, type)
    }
    @TypeConverter
    fun currentToString(obj: Current?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    // Convert Hourly object
    @TypeConverter
    fun toHourly(obj: String?): Hourly? {
        val gson = Gson()
        val type = object : TypeToken<Hourly?>() {}.type
        return gson.fromJson(obj, type)
    }
    @TypeConverter
    fun hourlyToString(obj: Hourly?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    // Convert Hourly object
    @TypeConverter
    fun toWeather(obj: String?): Weather? {
        val gson = Gson()
        val type = object : TypeToken<Weather?>() {}.type
        return gson.fromJson(obj, type)
    }
    @TypeConverter
    fun hourlyToString(obj: Weather?): String? {
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



//    // Convert Houly object
//    @TypeConverter
//    fun toHourly(hourly: String?): Hourly? {
//        val gson = Gson()
//        val type = object : TypeToken<Hourly?>() {}.type
//        return gson.fromJson(hourly, type)
//    }
//
//    // Convert Weather object
//    @TypeConverter
//    fun toWeather(weather: String?): Weather? {
//        val gson = Gson()
//        val type = object : TypeToken<Weather?>() {}.type
//        return gson.fromJson(weather, type)
//    }

}