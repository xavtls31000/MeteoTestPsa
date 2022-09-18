package fr.milweb_tls.meteotestpsa.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import fr.milweb_tls.meteotestpsa.R

/**
 * Created by Xavier Mangiapanelli on 15/09/2022.
 */
object StaticMethode {

    fun startTransactionFragment(activity: FragmentManager, fragment: Fragment, bundle: Bundle?) {
        fragment.arguments = bundle
        activity.beginTransaction()
            .setCustomAnimations(
                R.anim.rigth_to_left,  // enter
                androidx.appcompat.R.anim.abc_fade_out // exit
            )
            .replace(R.id.activity_main_frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }



}