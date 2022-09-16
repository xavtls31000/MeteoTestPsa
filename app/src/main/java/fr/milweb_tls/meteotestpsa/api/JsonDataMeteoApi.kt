package fr.milweb_tls.meteotestpsa.api

import android.content.Context
import androidx.fragment.app.FragmentManager

class JsonDataMeteoApi (var context: Context, var fragmentManager: FragmentManager){


    fun getProductJson(city: String) {
        TransfertFile(context, fragmentManager).getCurrentData(city)



    }
}