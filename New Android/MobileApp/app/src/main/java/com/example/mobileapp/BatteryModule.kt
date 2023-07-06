package com.example.mobileapp

import dagger.Module
import dagger.Provides


@Module
class BatteryModule {

    @Provides
    fun providesBattery(): Battery{
        return Battery()
    }
}