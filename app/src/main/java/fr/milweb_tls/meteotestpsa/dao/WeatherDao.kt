package fr.milweb_tls.meteotestpsa.dao

import androidx.room.*
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.entities.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: Weather)

    @Delete()
    fun deleteWeather(weather: Weather)

    @Query("SELECT * FROM T_Weather ORDER BY date")
    fun getAllWeatherByCity(): List<Weather>



}