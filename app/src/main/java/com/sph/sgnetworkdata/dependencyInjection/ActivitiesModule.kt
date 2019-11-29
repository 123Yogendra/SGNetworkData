package com.sph.sgnetworkdata.dependencyInjection

import com.sph.sgnetworkdata.userInterface.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}