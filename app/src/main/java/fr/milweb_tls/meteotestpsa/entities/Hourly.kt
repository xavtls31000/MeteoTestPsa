package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import fr.milweb_tls.meteotestpsa.util.ConverterRoom

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_Hourly",
    //indices = [Index(value = ["codePostal"], unique = true)],
)

data class Hourly(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var dt: Long = 0,
    var temp: Float = 0F,
    var feels_like: Float = 0F,
    var pressure: Int = 0,
    var humidity: Int = 0,
    var dew_point: Float = 0F,
    var clouds: Int = 0,
    var wind_speed: Float = 0F,
    var wind_deg: Int = 0,
    var wind_gust: Float = 0F
)
