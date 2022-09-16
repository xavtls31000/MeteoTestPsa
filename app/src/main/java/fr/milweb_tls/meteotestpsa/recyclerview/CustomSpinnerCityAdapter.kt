package fr.milweb_tls.meteotestpsa.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.entities.City

class CustomSpinnerCityAdapter(context: Context, listCity: List<City>):
      ArrayAdapter<City>(context,0,listCity){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return listView(position, convertView, parent)

    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return listView(position, convertView, parent)

    }

    private fun listView(position: Int, convertView: View?, parent: ViewGroup): View {

        val list = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_city,parent,false)

        list.let {
            val txt = view.findViewById<TextView>(R.id.txt_spinner)
            val weatherSpinner = view.findViewById<ImageView>(R.id.weather_spinner)
            txt.text=list!!.name

        }
        return view
    }

}