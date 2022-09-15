package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_Current",
    //indices = [Index(value = ["codePostal"], unique = true)],
)
class Current : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var dt: Long = 0
    var sunrise: Long = 0
    var sunset: Long = 0
    var temp: Float = 0F
    var feels_like: Float = 0F
    var pressure: Int = 0
    var humidity: Int = 0
    var dew_point: Float = 0F
    var clouds: Int = 0
    var visibility: Int = 0
    var wind_speed: Int = 0
    var wind_deg: Int = 0
}
