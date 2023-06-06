package com.example.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var  nameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText : EditText = findViewById(R.id.editText)
        nameText = findViewById(R.id.textView2)
        val btn : Button = findViewById(R.id.saveBtn)

        getSharedPreferenceData()

        btn.setOnClickListener() {
            val enteredText = editText.text.toString()
            SaveNameInSharedPreference(enteredText)
        }

    }

    private fun SaveNameInSharedPreference(enteredText: String) {
        val sharedPreference : SharedPreferences =
            getSharedPreferences("Name", MODE_PRIVATE)

        //Writing thee shared preferences
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("xx", enteredText)
        editor.commit()
    }

    fun getSharedPreferenceData() {
        val sharedPreferences: SharedPreferences =
        getSharedPreferences("Name", MODE_PRIVATE)

        val s1 : String? = sharedPreferences.getString("xx", "")

        nameText.setText(s1)

    }


}