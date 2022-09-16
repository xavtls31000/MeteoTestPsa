package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_City",
    //indices = [Index(value = ["codePostal"], unique = true)],
)
data class City (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var codePostal: String = "",
    var name: String = ""

    )

{
    override fun toString(): String {
        return "City(id=$id, codePostal='$codePostal', name='$name')"
    }
}