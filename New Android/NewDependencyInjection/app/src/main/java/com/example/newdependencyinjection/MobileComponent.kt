package com.example.newdependencyinjection

import dagger.Component

@Component(modules = [BatteryModule::class, AmoledDisplayModule::class])
interface MobileComponent {
    //fun getMobileInstance() : Mobile

    fun inject(mainActivity: MainActivity)
}