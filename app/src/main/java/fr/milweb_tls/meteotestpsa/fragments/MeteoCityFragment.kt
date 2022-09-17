package fr.milweb_tls.meteotestpsa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.milweb_tls.meteotestpsa.R

/**
 * Created by xavier Mangiapanelli on 17/09/2022.
 */
class MeteoCityFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_meteo_city, container, false)




        return rootView
    }

    companion object {    }
}