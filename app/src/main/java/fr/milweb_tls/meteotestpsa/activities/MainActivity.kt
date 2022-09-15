package fr.milweb_tls.meteotestpsa.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.base.BaseActivity

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class MainActivity : BaseActivity(),
    AdapterView.OnItemSelectedListener

{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}