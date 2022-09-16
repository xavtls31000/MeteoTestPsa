package fr.milweb_tls.meteotestpsa.webServices

import android.content.res.Resources
import android.util.Log
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import fr.milweb_tls.meteotestpsa.interfaces.Constantes
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.BASE_URL_SERVER
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.KEY_API
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.MeteoTestPsaServices
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MeteoTestPsaApi (){

    fun getCurrentData() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: MeteoTestPsaServices = retrofit.create(MeteoTestPsaServices::class.java)
        var call: Call<CurrentWeather> = service.getDataMeteoForCity("toulouse", KEY_API)

        call.enqueue(object : Callback<CurrentWeather> {
            override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {

                if (response.code() === 200) {

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