package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import fr.milweb_tls.meteotestpsa.util.ConverterRoom

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_DataMeteo",
    //indices = [Index(value = ["codePostal"], unique = true)],
)

@TypeConverters(ConverterRoom::class)
data class DataMeteo(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var lat: Float = 0F,
    var lon: Float = 0F,
    var current: Current?,
    var weather: Weather,
    var hourly: Hourly

)

{

}
