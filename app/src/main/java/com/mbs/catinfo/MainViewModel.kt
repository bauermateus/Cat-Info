package com.mbs.catinfo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(repository: CatRepository) : ViewModel() {

    val service = RetrofitClient.createGetService()
    private val call = service.list()
    val _resp =  MutableLiveData<List<CatsModel>>()
    val resp: LiveData<List<CatsModel>> = _resp
    fun startRetrofitService() {
    call.enqueue(object: Callback<List<CatsModel>> {
        override fun onResponse(
            call: Call<List<CatsModel>>, response: Response<List<CatsModel>>,
        ) {
            if (response.isSuccessful) {
                _resp.value = response.body()
            }
        }

        override fun onFailure(call: Call<List<CatsModel>>, t: Throwable) {

        }
    })}


    class Factory(private val repository: CatRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}