package com.example.mobileapp

import dagger.Module
import dagger.Provides

@Module
class AmoledDisplayModule {

    @Provides
    fun providesAmoledDisplay(amoleDdisplay: AMOLEDdisplay) : Display {
        return AMOLEDdisplay()

    }

}