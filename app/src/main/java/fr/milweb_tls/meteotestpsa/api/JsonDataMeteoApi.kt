package fr.milweb_tls.meteotestpsa.api

import android.content.Context
import androidx.fragment.app.FragmentManager
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.webServices.TransfertFile

class JsonDataMeteoApi (var context: Context, var fragmentManager: FragmentManager){

    /** Call API OpenWheather **/
    fun getCurrentDataMeteoJson(city: City) {
        TransfertFile(context, fragmentManager).getCurrentData(city)



    }
}