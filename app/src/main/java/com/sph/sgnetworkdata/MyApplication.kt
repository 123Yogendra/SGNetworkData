package com.sph.sgnetworkdata

import android.app.Activity
import android.app.Application
import com.sph.sgnetworkdata.dependencyInjection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/*
HasActivityInjector ==> dagger-android
*/

class MyApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.create() // equals DaggerAppComponent.builder().build()

        appComponent.inject(this)
    }
}