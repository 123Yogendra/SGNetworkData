package com.sph.sgnetworkdata.di.modules

import com.sph.sgnetworkdata.userInterface.NetworkDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): NetworkDataActivity
}