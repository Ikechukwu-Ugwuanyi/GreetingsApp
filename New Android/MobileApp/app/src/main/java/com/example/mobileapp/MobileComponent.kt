package com.example.mobileapp

import dagger.Component

@Component
interface MobileComponent {
    fun getMobileInstance() : Mobile
}