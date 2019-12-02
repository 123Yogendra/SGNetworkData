package com.sph.sgnetworkdata.userInterface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sph.sgnetworkdata.di.modules.NetworkModule
import com.sph.sgnetworkdata.network.NetworkStatus
import com.sph.sgnetworkdata.network.model.BaseDataStore
import com.sph.sgnetworkdata.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class NetworkDataActivityViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var networkModule: NetworkModule

    val networkLiveData = MutableLiveData<BaseDataStore>()
    val statusLiveData = MutableLiveData<NetworkStatus>()


    fun fetchDataDetail() {

        val networkDataAPI =
            networkModule.provideNetworkDataApi(networkModule.provideRetrofitInterface())

        val networkDataAPICall =
            networkDataAPI.getNetworkDataList(
                Constants.RESOURCE_ID,
                Constants.LIMIT
            )

        networkDataAPICall.enqueue(object : Callback<BaseDataStore> {

            override fun onResponse(
                call: Call<BaseDataStore>?,
                response: Response<BaseDataStore>?
            ) {
                networkLiveData.value = response?.body()

            }

            override fun onFailure(call: Call<BaseDataStore>?, t: Throwable?) {
                statusLiveData.value = NetworkStatus.FAIL
            }
        })

        if(!networkModule.isConnected) {
            // off line
            statusLiveData.value = NetworkStatus.INTERNET_CONNECTION
        }

    }





}