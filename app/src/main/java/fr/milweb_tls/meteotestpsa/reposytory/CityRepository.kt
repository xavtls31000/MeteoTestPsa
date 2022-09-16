package fr.milweb_tls.meteotestpsa.reposytory

import fr.milweb_tls.meteotestpsa.dao.CityDao
import fr.milweb_tls.meteotestpsa.entities.City

class CityRepository(private val cityDao: CityDao) {

    // Get list all city
    fun getListAllCity(): List<City> {
        return cityDao.getAllCity()
    }

    // Get list all city
    fun insertListAllCity(list: MutableList<City>) {
        return cityDao.insertListCity(list)
    }
}