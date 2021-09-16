package com.example.tryonthis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tryonthis.model.Country


class CountryAdapter(
    var countryList: ArrayList<Country>,
    private val activity: MainActivity,
    private val onItemClicked: (Int) -> Unit
) :
    RecyclerView.Adapter<VHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return VHolder(v)

    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.tvText.text = countryList[position].title

        Glide.with(activity)
            .load("http://restcountries.eu/data/afg.svg")
            .apply(RequestOptions().centerCrop())
            .into(holder.ivImage)

        holder.itemView.setOnClickListener {
           onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}


