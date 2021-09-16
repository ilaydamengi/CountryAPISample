package com.example.tryonthis.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("name")
    var title:String,
    @SerializedName("flag")
    var image:String,
    @SerializedName("region")
    var region : String,
    @SerializedName("subregion")
    var subRegion : String,
    @SerializedName("population")
    var population : Int,
    @SerializedName("borders")
    var borders : ArrayList<String>,

) : Serializable










