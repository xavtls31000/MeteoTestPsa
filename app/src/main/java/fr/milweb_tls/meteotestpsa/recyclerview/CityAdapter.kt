package fr.milweb_tls.meteotestpsa.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.entities.City


/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class CityAdapter (var fragmentManager: FragmentManager): ListAdapter<City, CityViewHolder>(PRODUCT_COMPARATOR) {


    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_city_adapter, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, context!!, fragmentManager)
    }



    companion object {
        private val PRODUCT_COMPARATOR = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem.name == newItem.name
            }



        }
    }




}