package fr.milweb_tls.meteotestpsa.reposytory

import fr.milweb_tls.meteotestpsa.dao.WeatherDao
import fr.milweb_tls.meteotestpsa.entities.Weather

class WeatherRepository(private val weatherDao: WeatherDao) {

    /** Delete weather **/
    fun deleteWeather(weather: Weather) {
        return weatherDao.deleteWeather(weather)
    }

    /** Insert weather **/
    fun insertWeather(weather: Weather) {
        return weatherDao.insertWeather(weather)
    }

    /** Get last date wheather by city **/
    fun getWeatherForCity(city: String): Weather {
        return weatherDao.getWeatherForCity(city)
    }


}