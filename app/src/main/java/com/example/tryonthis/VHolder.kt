package com.example.tryonthis

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     var ivImage : ImageView
     var tvText : TextView

     init {
         ivImage = itemView.findViewById(R.id.countryIV)
         tvText = itemView.findViewById(R.id.countryListNameTV)
     }


}