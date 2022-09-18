package fr.milweb_tls.meteotestpsa.dao

import androidx.room.*
import fr.milweb_tls.meteotestpsa.entities.Weather

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: Weather)

    @Delete()
    fun deleteWeather(weather: Weather)

    @Query("SELECT * FROM T_Weather WHERE city =:cityName ")
    fun getWeatherForCity(cityName: String): Weather



}