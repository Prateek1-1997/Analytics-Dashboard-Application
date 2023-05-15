package com.Presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Models.MainRepository
import com.RequestResult
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.ExampleJson2KtKotlin
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<ExampleJson2KtKotlin>()
    val errorMessage = MutableLiveData<String>()

    val dashboardDataMLD:
            MutableLiveData<RequestResult<Any>> by lazy {
        MutableLiveData<RequestResult<Any>>()
    }

    fun getAllMovies() {
        dashboardDataMLD.value = RequestResult.Loading("")
        viewModelScope.launch {
            try{
                val data= repository.getPageData()
                dashboardDataMLD.value = RequestResult.Success(
                    data
                )
            }catch(e:Exception){
                e.printStackTrace()
                dashboardDataMLD.value = RequestResult.Error(e)
            }
        }
    }



}