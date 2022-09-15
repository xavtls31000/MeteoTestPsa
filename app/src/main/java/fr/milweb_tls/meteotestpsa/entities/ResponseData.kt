package fr.milweb_tls.meteotestpsa.entities

import lombok.AllArgsConstructor
import lombok.ToString

@AllArgsConstructor @ToString
class ResponseData (var dataMeteo: DataMeteo) {

    @AllArgsConstructor @ToString
    class DataMeteo(
        var lat: Float = 0F,
        var lon: Float = 0F,
        var timezone: String = "",
        var timezone_offset: String = "",
        var current: Current?,
        var weather: Weather,
        var hourly: Hourly
    ) {
        @AllArgsConstructor @ToString
        class Current(
            var dt: Long = 0,
            var sunrise: Long = 0,
            var sunset: Long = 0,
            var temp: Float = 0F,
            var feels_like: Float = 0F,
            var pressure: Int = 0,
            var humidity: Int = 0,
            var dew_point: Float = 0F,
            var clouds: Int = 0,
            var visibility: Int = 0,
            var wind_speed: Int = 0,
            var wind_deg: Int = 0
        ) {
            @AllArgsConstructor @ToString
            class Weather(
                var main: String = "",
                var description: String = "",
                var icon: String = ""
            )
        }
        @AllArgsConstructor @ToString
        class Hourly(
            var dt: Long = 0,
            var temp: Float = 0F,
            var feels_like: Float = 0F,
            var pressure: Int = 0,
            var humidity: Int = 0,
            var dew_point: Float = 0F,
            var clouds: Int = 0,
            var wind_speed: Float = 0F,
            var wind_deg: Int = 0,
            var wind_gust: Float = 0F
        )

    }
}