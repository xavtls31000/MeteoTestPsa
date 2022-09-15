package fr.milweb_tls.meteotestpsa.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */

@Entity(
    tableName = "T_Ville",
    //indices = [Index(value = ["codePostal"], unique = true)],
)
data class Villes (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var codePostal: String = "",
    var name: String = ""

    )

{
    override fun toString(): String {
        return "Villes(id=$id, codePosta='$codePostal', name='$name')"
    }
}