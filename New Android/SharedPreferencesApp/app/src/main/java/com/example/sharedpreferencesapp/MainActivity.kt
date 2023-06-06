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

        displaySharedPreferenceData()

        btn.setOnClickListener() {
            val enteredText = editText.text.toString()
            saveNameInSharedPreference(enteredText)
        }


    }

    private fun saveNameInSharedPreference(enteredText: String) {
        val sharedPreferences : SharedPreferences =
            getSharedPreferences("Name", MODE_PRIVATE)

        val editor : SharedPreferences.Editor =
            sharedPreferences.edit()
        editor.putString("name", enteredText)
        editor.commit()

    }

    private fun displaySharedPreferenceData() {
        val sharedPreferences : SharedPreferences =
            getSharedPreferences("Name", MODE_PRIVATE)

        val s1 : String? = sharedPreferences.getString("name", "")
        nameText.setText(s1)
    }


}