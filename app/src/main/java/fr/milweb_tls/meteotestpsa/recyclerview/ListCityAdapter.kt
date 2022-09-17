package fr.milweb_tls.meteotestpsa.recyclerview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.activities.MainActivity
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository


/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class ListCityAdapter(var fragmentManager: FragmentManager)
    : RecyclerView.Adapter<ListCityAdapter.ListCityViewHolder>(){

    var context: Context? = null
    val listCity = CityRepository(BaseActivity.databaseRoom.cityDao()).getListAllCity() as MutableList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCityViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_city_adapter, parent, false)
        return ListCityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListCityViewHolder, position: Int) {
        val dataCity = listCity[position]
        holder.bind(dataCity, context!!, fragmentManager)
    }


    override fun getItemCount(): Int {
        return listCity.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int){
        listCity.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listCity.size)
        //notifyDataSetChanged()
    }

    companion object {
    }

    /** inner class ListCityViewHolder **/
    inner class ListCityViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var cityImgWeather: ImageView = itemView.findViewById(R.id.list_city_img_weather)
        private var cityName: TextView = itemView.findViewById(R.id.list_city_city_name)
        private var cityCodePostal: TextView = itemView.findViewById(R.id.list_city_citycp)
        private var cityDelete: ImageView = itemView.findViewById(R.id.list_city_delete)
        var context: Context? = null
        var fragmentManager: FragmentManager? = null
        var city: City? = null

        fun bind(city: City, context: Context, fragmentManager: FragmentManager?){

            this.context = context
            this.fragmentManager = fragmentManager
            this.city = city

            cityName.text = city.name
            cityCodePostal.text = city.codePostal
            cityImgWeather.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_meteo))

            // listener
            cityDelete.setOnClickListener(this)

        }

        override fun onClick(view: View?) {

            when(view!!.id) {

                R.id.list_city_delete -> {

                    if(city!=null) {

                        deleteCity(city!!)

                    }
                }
            }
        }

        fun deleteCity(city: City){
            val myAlertDialog = AlertDialog.Builder(MainActivity.context)
            myAlertDialog.setCancelable(false)
            val viewBox = MainActivity.activity.layoutInflater.inflate(R.layout.box_delete_city, null)

            /** click valider **/
            myAlertDialog.setPositiveButton("Oui") { _, _ ->
                CityRepository(BaseActivity.databaseRoom.cityDao()).deleteCity(city)
                removeItem(position)
            }

            /** Click sur bouton Return **/
            myAlertDialog.setNeutralButton("Non") { dialog, _ -> dialog.cancel() }

            // Affichage viewBox
            myAlertDialog.setView(viewBox)
            val dialog = myAlertDialog.create()
            dialog.show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(
                MainActivity.context,R.color.btn_ville))
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(ContextCompat.getColor(
                MainActivity.context,R.color.btn_ville))
            //dialog.window!!.setLayout(1000, 350)
        }


    }




}