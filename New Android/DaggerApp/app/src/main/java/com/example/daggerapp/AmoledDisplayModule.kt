package com.example.daggerapp

import dagger.Module
import dagger.Provides

@Module
class AmoledDisplayModule {

    @Provides
    fun providesAmoledDisplay(amoleDisplay: AMOLEDdisplay) : Display {
        return AMOLEDdisplay()
    }
}