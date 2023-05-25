package com.example.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nameTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        nameTextView = findViewById(R.id.textView2)
        val btn: Button = findViewById(R.id.saveBtn)

        DisplaySavedName()

        btn.setOnClickListener() {
            val enteredText : String = editText.text.toString()
            SaveNameInSharedPref(enteredText)
        }
    }

    private fun SaveNameInSharedPref(enteredText: String) {
        //Saving the text into Shared Preferences
        val sharedPreferences : SharedPreferences =
            getSharedPreferences("UserName", MODE_PRIVATE)

        //Writing data to shared Preferences
        val editor: SharedPreferences.Editor =
            sharedPreferences.edit()

        editor.putString("name", enteredText)
        editor.commit()

    }

    fun DisplaySavedName() {
        //Reading data from sharedPreferences
        val sharedPreferences : SharedPreferences =
            getSharedPreferences("UserName", MODE_PRIVATE)

        val s1 : String? = sharedPreferences.getString("name", "")

        nameTextView.setText(s1)

    }
}