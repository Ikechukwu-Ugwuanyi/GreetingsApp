package com.example.newdependencyinjection

import dagger.Module
import dagger.Provides

@Module
class BatteryModule {

    @Provides
    fun providesBattery(): Battery{
        return Battery()
    }
}