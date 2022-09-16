package fr.milweb_tls.meteotestpsa.api

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentManager
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import fr.milweb_tls.meteotestpsa.interfaces.Constantes
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.KEY_API
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.MeteoTestPsaServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TransfertFile(var context: Context, var fragmentManager: FragmentManager) {

    /** Call Api OpenWeather **/
    fun getCurrentData(city: String) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: MeteoTestPsaServices = retrofit.create(MeteoTestPsaServices::class.java)
        val call: Call<CurrentWeather> = service.getDataMeteoForCity(city, KEY_API)

        call.enqueue(object : Callback<CurrentWeather> {
            override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {

                if (response.code() == 200) {

                    val weatherResponse: CurrentWeather = response.body()!!
                    Log.d(LOG_TAG, "weatherResponse: " + weatherResponse.weather[0])


                } else {
                    Log.d(LOG_TAG, "error response: " + response.raw())
                }
            }

            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.d(LOG_TAG, "error response: " + t)
            }
        })
    }


}