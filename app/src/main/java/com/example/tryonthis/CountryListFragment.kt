package com.example.tryonthis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tryonthis.model.Country
import kotlinx.android.synthetic.main.country_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryListFragment : Fragment() {
    private var countryList: List<Country> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webService = WebService.create().getCountry()
        webService.enqueue(object : Callback<List<Country>> {

            override fun onResponse(
                call: Call<List<Country>>,
                response: Response<List<Country>>
            ) {

                response.body()?.let {
                    countryList = it

                    recyclerView.setHasFixedSize(true)
                    recyclerView.layoutManager = LinearLayoutManager(activity)
                    recyclerView.adapter = activity?.let { activity ->
                        CountryAdapter(
                            countryList as ArrayList<Country>,
                            this@CountryListFragment.activity as MainActivity
                        ) { pos ->
                            onItemClicked(pos)
                        }
                    }

                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("LogDeneme", "En error occured: " + t.message)
            }

        })


    }

    private fun onItemClicked(pos: Int) {
        Bundle().apply {
            putSerializable("countryModel", countryList[pos])

            val myFragment: Fragment = CountryDetailFragment()
            myFragment.arguments=this
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment, myFragment)?.addToBackStack(null)?.commit()
        }
    }

}


