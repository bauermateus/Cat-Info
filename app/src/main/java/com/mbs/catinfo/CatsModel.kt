package com.mbs.catinfo

import com.google.gson.annotations.SerializedName


data class CatsModel (

    @SerializedName("breeds" ) var breeds : ArrayList<Breeds> = arrayListOf(),
    @SerializedName("id"     ) var id     : String?           = null,
    @SerializedName("url"    ) var url    : String?           = null,
    @SerializedName("width"  ) var width  : Int?              = null,
    @SerializedName("height" ) var height : Int?              = null

)