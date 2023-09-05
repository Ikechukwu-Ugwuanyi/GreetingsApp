package com.example.daggerapp

import dagger.Component

@Component
interface MobileComponent {
    fun getMobileInstance() : Mobile
}

