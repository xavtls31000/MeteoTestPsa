package fr.milweb_tls.meteotestpsa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.recyclerview.ListCityAdapter
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository


/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class ListCityFragment : Fragment() {

    private var listCityAdapter: ListCityAdapter? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_list_city, container, false)
        recyclerView = rootView.findViewById(R.id.rcv_list_city)
        configureRecyclerView()

        return rootView
    }

    private fun configureRecyclerView() {
        //val listCity = CityRepository(BaseActivity.databaseRoom.cityDao()).getListAllCity()
        //listCityAdapter = ListCityAdapter(requireActivity().supportFragmentManager, listCity as MutableList)
        listCityAdapter = ListCityAdapter(requireActivity().supportFragmentManager)
        recyclerView!!.adapter = listCityAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(activity)

    }

    companion object {

    }
}