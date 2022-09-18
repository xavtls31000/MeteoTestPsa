package fr.milweb_tls.meteotestpsa.reposytory

import fr.milweb_tls.meteotestpsa.dao.CityDao
import fr.milweb_tls.meteotestpsa.entities.City
import kotlinx.coroutines.flow.Flow

class CityRepository(private val cityDao: CityDao) {

    /** Get list all city **/
    fun deleteCity(city: City) {
        return cityDao.deleteCity(city)
    }

    /** Get list all city **/
    fun getListAllCity(): List<City> {
        return cityDao.getAllCity()
    }

    /** Get list all city **/
    fun insertListAllCity(list: MutableList<City>) {
        return cityDao.insertListCity(list)
    }

    /** Get All City for viewModel **/
    val allCity: Flow<List<City>> = cityDao.getListCity()

}