package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_Weather",
    //indices = [Index(value = ["codePostal"], unique = true)],
)
data class Weather(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var main: String = "",
    var description: String = "",
    var icon: String = ""
)
