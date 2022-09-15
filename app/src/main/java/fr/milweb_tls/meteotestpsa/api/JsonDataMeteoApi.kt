package fr.milweb_tls.meteotestpsa.api

import android.content.Context
import androidx.fragment.app.FragmentManager

class JsonDataMeteoApi (var context: Context, var fragmentManager: FragmentManager){

    fun getProductJson(codeProduct: String?) {
        TransfertFile(context, fragmentManager).getJsonDataMeteo()
    }
}