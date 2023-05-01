package com.room.ps.viewmodeldemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import ps.room.viewmodellivedata.R

class MainActivity : AppCompatActivity() {

	lateinit var model: MainActivityViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

//		model = MainActivityDataGenerator()

		model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

		val myRandomNumber = model.getNumber()

		myRandomNumber.observe(this, Observer<String> { number ->
			tvNumber.text = number
			Log.i(TAG, "Random Number Set")
		})

		bRandom.setOnClickListener {
			model.createNumber()
		}
	}

	companion object {
		private val TAG = MainActivity::class.simpleName
	}
}
