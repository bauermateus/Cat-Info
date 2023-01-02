package com.mbs.catinfo

import retrofit2.Call
import retrofit2.http.GET

interface CatService {
    @GET("search?limit=10&has_breeds=1&api_key=743b4f4b-0ef6-4fed-bdd6-5108667fc3f5")
    fun list(): Call<List<CatsModel>>
}