package com.example.tryonthis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tryonthis.model.Country
import kotlinx.android.synthetic.main.countrydetail.*


class CountryDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.countrydetail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      val countryModel : Country = arguments?.getSerializable("countryModel") as Country
        countryDetailTitleTV.text = countryModel.title
        countryRegion.text = countryModel.region
        countrySubRegion.text = countryModel.subRegion
        countryPopulation.text= countryModel.population.toString()
        countryBorders.text= countryModel.borders.toString()


     }



}