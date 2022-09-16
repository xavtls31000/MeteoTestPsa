package fr.milweb_tls.meteotestpsa.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.entities.City

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class CityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var cityImgWeather: ImageView = itemView.findViewById(R.id.list_city_img_weather)
    private var cityName: TextView = itemView.findViewById(R.id.list_city_city_name)
    private var cityCodePostal: TextView = itemView.findViewById(R.id.list_city_citycp)
    private var cityDelete: ImageView = itemView.findViewById(R.id.list_city_delete)
    var context: Context? = null
    var fragmentManager: FragmentManager? = null

    fun bind(city: City, context: Context, fragmentManager: FragmentManager?){

        this.context = context
        this.fragmentManager = fragmentManager

        cityName.text = city.name
        cityCodePostal.text = city.codePostal
        cityImgWeather.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_meteo))

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}