package fr.milweb_tls.meteotestpsa.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.reposytory.WeatherRepository
import fr.milweb_tls.meteotestpsa.util.ImgageMeteo

class CustomSpinnerCityAdapter(context: Context, listCity: List<City>):
      ArrayAdapter<City>(context,0,listCity){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return listView(position, convertView, parent)

    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return listView(position, convertView, parent)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun listView(position: Int, convertView: View?, parent: ViewGroup): View {

        val list = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_city,parent,false)

        list.let {
            val txt = view.findViewById<TextView>(R.id.txt_spinner)
            val weatherSpinner = view.findViewById<ImageView>(R.id.weather_spinner)
            txt.text=list!!.name
            val cityWeather = WeatherRepository(BaseActivity.databaseRoom.weatherDao()).getWeatherForCity(it!!.name)
            if (cityWeather!=null){
                val image = ImgageMeteo().getDataMeteo(cityWeather.icon)
                weatherSpinner.setImageDrawable(context.getDrawable(image.main_image))
            } else weatherSpinner.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_meteo))

        }
        return view
    }

}