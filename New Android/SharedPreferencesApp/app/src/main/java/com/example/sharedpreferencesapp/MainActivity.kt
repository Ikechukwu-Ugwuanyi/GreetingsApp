package com.example.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val btn: Button = findViewById(R.id.saveBtn)

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
}