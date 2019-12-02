package com.sph.sgnetworkdata.di.components


import com.sph.sgnetworkdata.MyApplication
import com.sph.sgnetworkdata.di.modules.ActivitiesModule
import com.sph.sgnetworkdata.di.modules.NetworkModule
import dagger.Component

@Component(
    modules = [
        ActivitiesModule::class, NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(myApplication: MyApplication)
    fun inject (networkModule: NetworkModule)

}