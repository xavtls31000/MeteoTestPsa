package fr.milweb_tls.meteotestpsa.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.util.StaticMethode

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class MainActivity : BaseActivity(),
    AdapterView.OnItemSelectedListener

{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureDownMenu()

    }

    // Configure menu du bas
    private fun configureDownMenu(){
        val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.navigation_home -> {
                    intent = Intent(application, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.navigation_input_ville -> {
                    Log.d(LOG_TAG, "navigation_input_ville")
                }

                R.id.navigation_list_ville -> {
                    Log.d(LOG_TAG, "navigation_list_ville")
                }

                R.id.navigation_meteo -> {
                    Log.d(LOG_TAG, "navigation_meteo")
                }
            }
            true
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}