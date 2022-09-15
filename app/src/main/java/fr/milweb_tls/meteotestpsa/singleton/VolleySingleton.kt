package fr.milweb_tls.meteotestpsa.singleton

import android.annotation.SuppressLint
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton private constructor(context: Context) {

    private var requestQueue: RequestQueue?

    fun getRequestQueue(): RequestQueue? {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mctx.applicationContext)
        }
        return requestQueue
    }

    fun <T> addToRequestQue(request: Request<T>?) {
        requestQueue!!.add(request)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var volleySingleton: VolleySingleton? = null
        @SuppressLint("StaticFieldLeak")
        private lateinit var mctx: Context
        @Synchronized
        fun getInstance(context: Context): VolleySingleton? {
            if (volleySingleton == null) {
                volleySingleton = VolleySingleton(context)
            }
            return volleySingleton
        }
    }

    init {
        mctx = context
        requestQueue = getRequestQueue()

    }
}