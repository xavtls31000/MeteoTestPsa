package fr.milweb_tls.meteotestpsa.entities

import com.google.gson.annotations.SerializedName
import lombok.AllArgsConstructor
import lombok.ToString
import java.io.Serializable

/**
Created by xavier Mangiapanelli on 16/09/2022.

Cette classe permet de mapper je json response de l'api OpenWeather

 */

@AllArgsConstructor @ToString
class CurrentWeather (): Serializable {

    var coord: Coord? = null
    var sys: Sys? = null
    var weather = ArrayList<Weather>()
    var main: Main? = null
    var wind: Wind? = null
    var rain: Rain? = null
    var clouds: Clouds? = null
    var dt = 0f
    var id = 0
    var name: String? = null
    var cod = 0f


    class Weather : Serializable{
        var id = 0L
        var main: String? = null
        var description: String? = null
        var icon: String? = null

        override fun toString(): String {
            return "Weather(id=$id, main=$main, description=$description, icon=$icon)"
        }

    }

    class Clouds: Serializable {
        var all = 0f
    }

    class Rain: Serializable {
        var h3 = 0f
    }

    class Wind: Serializable {
        var speed = 0f
        var deg = 0f
    }

    class Main: Serializable {
        var temp = 0f
        var humidity = 0f
        var pressure = 0f
        var temp_min = 0f
        var temp_max = 0f

        override fun toString(): String {
            return "Main(temp=$temp, humidity=$humidity, pressure=$pressure, temp_min=$temp_min, temp_max=$temp_max)"
        }
    }

    class Sys: Serializable {
        var country: String? = null
        var sunrise: Long = 0
        var sunset: Long = 0
    }

    class Coord: Serializable {
        var lon = 0f
        var lat = 0f
    }
}