package fr.milweb_tls.meteotestpsa.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.api.JsonDataMeteoApi
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.webServices.MeteoTestPsaApi

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val btnValidate = rootView.findViewById<Button>(R.id.input_ville_btn_validate)
        val city = rootView.findViewById<EditText>(R.id.input_city_city)
        btnValidate.setOnClickListener {
            Log.d(LOG_TAG,"ville: " + city.text)
            BaseActivity.databaseRoom.cityDao().insertCity(City(0,"",city.text.toString()))
            JsonDataMeteoApi(requireContext(), requireActivity().supportFragmentManager).getProductJson(city.text.toString())
            //MeteoTestPsaApi(requireContext().resources).getCurrentData()
        }
        return rootView
    }

    companion object {

        var animationList = intArrayOf(
            R.anim.layout_animation_up_to_down,
            R.anim.layout_animation_right_to_left,
            R.anim.layout_animation_down_to_up,
            R.anim.layout_animation_left_to_right
        )
    }
}