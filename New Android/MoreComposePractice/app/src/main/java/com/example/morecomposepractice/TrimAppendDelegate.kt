package com.example.morecomposepractice

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TrimAppendDelegate : ReadWriteProperty<Any?, String> {

    private var trimAppendString = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimAppendString

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimAppendString = "Hi ${value.trim()}"
    }
}