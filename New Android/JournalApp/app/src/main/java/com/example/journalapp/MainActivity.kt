package com.example.journalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.journalapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //Firebase Auth Init.
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.createAcc.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.loginBtn.setOnClickListener() {
            loginWithEmailPassword(
                binding.email.text.toString().trim(),
                binding.password.text.toString().trim()
            )
        }

        //Auth Ref
        auth = Firebase.auth

    }

    private fun loginWithEmailPassword(email:String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->    

                //Sign in success
                if (task.isSuccessful){

                    var journal : JournalUser = JournalUser.instance!!
                    journal.userId  = auth.currentUser?.uid
                    journal.username = auth.currentUser?.displayName

                    goToJournalList()
                } else{
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        if (currentUser != null){
            goToJournalList()
        }
    }

    private fun goToJournalList() {
        var intent  = Intent(this, JournalList::class.java)
        startActivity(intent)
    }
}