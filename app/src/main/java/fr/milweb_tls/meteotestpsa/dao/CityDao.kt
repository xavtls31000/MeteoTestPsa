package fr.milweb_tls.meteotestpsa.dao

import androidx.room.*
import fr.milweb_tls.meteotestpsa.entities.City

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City)

    @Delete()
    fun deleteCity(city: City)

    @Query("SELECT * FROM T_City ORDER BY codePostal")
    fun getAllCity(): MutableList<City>



}