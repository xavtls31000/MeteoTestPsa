package fr.milweb_tls.meteotestpsa.api

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.GsonBuilder
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import fr.milweb_tls.meteotestpsa.entities.ResponseData
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.interfaces.Constantes
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.KEY_API
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.SERVER_ADDRESS
import fr.milweb_tls.meteotestpsa.interfaces.MeteoTestPsaServices
import fr.milweb_tls.meteotestpsa.interfaces.OnResponseTransfert
import fr.milweb_tls.meteotestpsa.singleton.VolleySingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

class TransfertFile(var context: Context, var fragmentManager: FragmentManager) {

    var uri: String? = null
    var onResponseTransfert: OnResponseTransfert? = null
    @SuppressLint("SimpleDateFormat")
    var dateFormat = SimpleDateFormat("yyyyMMdd-kkmmss")
    val serverUrl = "$SERVER_ADDRESS"

    fun getJsonDataMeteo() {
        uri = serverUrl
        var dataMeteo: ResponseData.DataMeteo
        val stringRequest = StringRequest(
            Request.Method.GET, uri, { response: String? ->
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()

                val fileJson = gson.fromJson(response,ResponseData::class.java)
                //dataMeteo = fileJson.toMutableList()
                Log.d(LOG_TAG, "response: " + response)
            }
        ) {

            //sendMsgToBroadcast(ERROR_VOLLEY, context.getString(R.string.msg_error_volley))
        }
        stringRequest.retryPolicy = DefaultRetryPolicy(
            5000,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        VolleySingleton.getInstance(context)!!.addToRequestQue(stringRequest)
    }

    fun getCurrentData(city: String) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: MeteoTestPsaServices = retrofit.create(MeteoTestPsaServices::class.java)
        var call: Call<CurrentWeather> = service.getDataMeteoForCity(city, KEY_API)

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