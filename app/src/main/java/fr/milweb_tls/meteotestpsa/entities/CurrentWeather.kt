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

    //@SerializedName("coord")
    var coord: Coord? = null
    //@SerializedName("sys")
    var sys: Sys? = null
    //@SerializedName("weather")
    var weather = ArrayList<Weather>()
    //@SerializedName("main")
    var main: Main? = null
    //@SerializedName("wind")
    var wind: Wind? = null
    //@SerializedName("rain")
    var rain: Rain? = null
    //@SerializedName("clouds")
    var clouds: Clouds? = null
    //@SerializedName("dt")
    var dt = 0f
    //@SerializedName("id")
    var id = 0
    //@SerializedName("name")
    var name: String? = null
    //@SerializedName("cod")
    var cod = 0f

    class Weather : Serializable{
        //@SerializedName("id")
        var id = 0L
        //@SerializedName("main")
        var main: String? = null
        //@SerializedName("description")
        var description: String? = null
        //@SerializedName("icon")
        var icon: String? = null

        override fun toString(): String {
            return "Weather(id=$id, main=$main, description=$description, icon=$icon)"
        }

    }

    class Clouds: Serializable {
        //@SerializedName("all")
        var all = 0f
    }

    class Rain: Serializable {
        //@SerializedName("3h")
        var h3 = 0f
    }

    class Wind: Serializable {
        //@SerializedName("speed")
        var speed = 0f
        //@SerializedName("deg")
        var deg = 0f
    }

    class Main: Serializable {
        //@SerializedName("temp")
        var temp = 0f
        //@SerializedName("humidity")
        var humidity = 0f
        //@SerializedName("pressure")
        var pressure = 0f
        //@SerializedName("temp_min")
        var temp_min = 0f
        //@SerializedName("temp_max")
        var temp_max = 0f
    }

    class Sys: Serializable {
        //@SerializedName("country")
        var country: String? = null
        //@SerializedName("sunrise")
        var sunrise: Long = 0
        //@SerializedName("sunset")
        var sunset: Long = 0
    }

    class Coord: Serializable {
        //@SerializedName("lon")
        var lon = 0f
        //@SerializedName("lat")
        var lat = 0f
    }
}