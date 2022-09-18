package fr.milweb_tls.meteotestpsa.dao

import androidx.room.*
import fr.milweb_tls.meteotestpsa.entities.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListCity(listCity: MutableList<City>)

    @Delete()
    fun deleteCity(city: City)

    @Query("SELECT * FROM T_City ORDER BY name")
    fun getAllCity(): List<City>

    /** get all city for cityViewModel **/
    @Query("SELECT * FROM T_City ORDER BY name")
    fun getListCity(): Flow<List<City>>

    /** get city by name **/
    @Query("SELECT * FROM T_City WHERE name =:cityName ")
    fun getCity(cityName: String): City

}