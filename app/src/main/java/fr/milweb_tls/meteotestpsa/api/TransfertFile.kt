package fr.milweb_tls.meteotestpsa.api

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.GsonBuilder
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.DataMeteo
import fr.milweb_tls.meteotestpsa.entities.ResponseData
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.SERVER_ADDRESS
import fr.milweb_tls.meteotestpsa.interfaces.OnResponseTransfert
import fr.milweb_tls.meteotestpsa.singleton.VolleySingleton
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
                Log.d(LOG_TAG, "fileJson: " + fileJson)
//                try {
//
//                    //Log.d(LOG_TAG, "list prix: " + listProductPrice);
//                    ProductPriceRepository(BaseActivity.BaseActivity.databaseRoom.productPriceDao()).insertListProductPrice(listProductPrice)
//                    val msg = ""
//
//                    onResponseTransfert = MainFragment()
//                    MainFragment().sendResponse(fragmentManager,  "" ,0)
//                } catch (e: Exception) {
//                    Log.d(LOG_TAG, "error : $e")
//
//                    MainFragment().sendResponse(fragmentManager,"",0)
//                }
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


}