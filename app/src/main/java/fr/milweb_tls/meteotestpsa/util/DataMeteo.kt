package fr.milweb_tls.meteotestpsa.util

import android.content.Context
import androidx.core.content.ContextCompat
import fr.milweb_tls.meteotestpsa.R

data class ImgMeteo (

    var main_image : Int = 0

    )
{
    fun getDataMeteo(icon: String): ImgMeteo {
        when(icon){
            "01d" -> main_image = R.mipmap.ic_01d
            "01n" -> main_image = R.mipmap.ic_01n
            "02d" -> main_image = R.mipmap.ic_02d
            "02n" -> main_image = R.mipmap.ic_02n
            "03d" -> main_image = R.mipmap.ic_03d
            "03n" -> main_image = R.mipmap.ic_03n
            "04d" -> main_image = R.mipmap.ic_04d
            "04n" -> main_image = R.mipmap.ic_04n
            "09d" -> main_image = R.mipmap.ic_09d
            "09n" -> main_image = R.mipmap.ic_09n
            "10d" -> main_image = R.mipmap.ic_10d
            "10n" -> main_image = R.mipmap.ic_10n
            "11d" -> main_image = R.mipmap.ic_11d
            "11n" -> main_image = R.mipmap.ic_11n
            "13d" -> main_image = R.mipmap.ic_13d
            "13n" -> main_image = R.mipmap.ic_13n
            "50d" -> main_image = R.mipmap.ic_50d
            "50n" -> main_image = R.mipmap.ic_50n
            else -> main_image = R.drawable.ic_meteo
        }
        return ImgMeteo(main_image)
    }
}