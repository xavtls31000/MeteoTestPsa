package fr.milweb_tls.meteotestpsa.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.entities.Weather
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.util.ImgageMeteo

/**
 * Created by xavier Mangiapanelli on 17/09/2022.
 */
class MeteoCityFragment : Fragment() {

    var weather: Weather? = null
    var errorType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Get City object and Weather object passing in bundle **/
        arguments?.let {
            errorType = it.getInt("errorType", 0)
            try {
                weather = (it.getSerializable("weather") as Weather?)!!
            }catch (e:Exception){}
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_meteo_city, container, false)
        /** Get id from layout **/
        val meteoImage = rootView.findViewById<ImageView>(R.id.frag_meteo_img_main)
        val meteoDescription = rootView.findViewById<TextView>(R.id.frag_meteo_description_main)
        val mainCity = rootView.findViewById<TextView>(R.id.frag_meteo_city)
        val currentTemp = rootView.findViewById<TextView>(R.id.frag_meteo_value_current_temp)
        val minTemp = rootView.findViewById<TextView>(R.id.frag_meteo_value_cold_temp)
        val maxTemp = rootView.findViewById<TextView>(R.id.frag_meteo_value_hot_temp)
        val offLine = rootView.findViewById<TextView>(R.id.frag_meteo_off_line)

        /** Set value **/
        if (weather!=null){
            val image = ImgageMeteo().getDataMeteo(weather!!.icon)
            meteoImage.setImageDrawable(requireContext().getDrawable(image.main_image))
            mainCity.text = weather!!.city
            meteoDescription.text = weather!!.description
            currentTemp.text = weather!!.curentTemp.toInt().toString() + "??"
            minTemp.text = weather!!.minTemp.toInt().toString() + "??"
            maxTemp.text = weather!!.maxTemp.toInt().toString() + "??"

            if(errorType==0){
                offLine.visibility = View.VISIBLE
                offLine.text = requireContext().getText(R.string.txt_off_line).toString() + " " + weather!!.date
            } else offLine.visibility = View.GONE
        }

        return rootView
    }

    companion object {    }
}