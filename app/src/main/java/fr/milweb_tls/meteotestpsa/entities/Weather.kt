package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_Weather",
    indices = [Index(value = ["date", "city"], unique = true),],
)

data class Weather(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var date: String = "",
    var main: String = "",
    var description: String = "",
    var icon: String = "",
    var city: String = "",
    var curentTemp: Float = 0f,
    var minTemp: Float = 0f,
    var maxTemp: Float = 0f
) : Serializable {

    override fun toString(): String {
        return "Weather(id=$id, date='$date', main='$main', description='$description', icon='$icon', city='$city', curentTemp=$curentTemp, minTemp=$minTemp, maxTemp=$maxTemp)"
    }

}
