package com.sph.sgnetworkdata.dependencyInjection


import com.sph.sgnetworkdata.MyApplication
import dagger.Component

@Component(
    modules = [
        ActivitiesModule::class
    ]
)
interface AppComponent {
    fun inject(myApplication: MyApplication)
}