@file:Suppress("DEPRECATION")

package fr.milweb_tls.meteotestpsa.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.fragments.ListCityFragment
import fr.milweb_tls.meteotestpsa.util.InitCity
import fr.milweb_tls.meteotestpsa.util.StaticMethode

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
@Suppress("DEPRECATION")
class MainActivity : BaseActivity()

{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureDownMenu()

        if(databaseRoom.cityDao().getAllCity().isEmpty()){
            InitCity().initListCity()
        }


    }

    override fun onResume() {
        super.onResume()
        context = this
        activity = this
    }

    /** Configuring bottom menu **/
    private fun configureDownMenu(){
        val navListener = OnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.navigation_home -> {
                    intent = Intent(application, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.navigation_list_ville -> {

                    StaticMethode.startTransactionFragment(this.supportFragmentManager, ListCityFragment(), null)
                }

                
            }
            true
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        @SuppressLint("StaticFieldLeak")
        lateinit var activity: MainActivity
    }


}