package com.example.morecomposepractice

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TrimAppendDelegate: ReadWriteProperty<Any?, String> {

    private var trimAppendedString = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimAppendedString

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimAppendedString = "Hi ${value.trim()}"
    }

}