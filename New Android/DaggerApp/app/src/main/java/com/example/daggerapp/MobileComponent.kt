package com.example.daggerapp

import dagger.Component

@Component(modules = [BatteryModule::class, AmoledDisplayModule::class])
interface MobileComponent {
    //fun getMobileInstance() : Mobile

    fun inject(testDagger: TestDagger)
}

