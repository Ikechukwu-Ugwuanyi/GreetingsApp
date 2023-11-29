package com.example.journalapp

import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.journalapp.databinding.ActivityAddJournalBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class AddJournalActivity : AppCompatActivity() {

    lateinit var binding:ActivityAddJournalBinding
    //Credentials
    var currentUserId: String = ""
    var currentUsername: String = ""

    //Firebase
    lateinit var auth: FirebaseAuth
    lateinit var user:FirebaseUser

    //Firestore
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference
    var collectionReference: CollectionReference = db.collection("Journal")
    lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_journal)

        storageReference = FirebaseStorage.getInstance().getReference()
        auth = FirebaseAuth.getInstance()

        binding.apply {
            postProgressBar.visibility = View.INVISIBLE

            //If there is a valid user logged in
            if(JournalUser.instance != null){
                currentUserId = JournalUser.instance!!.userId.toString()

                currentUsername = JournalUser.instance!!.username.toString()

                usernameTxt.text = currentUsername

            }

            //Clicking the Save Button
            postSaveJournalBtn.setOnClickListener(){
                saveJournal()
            }
        }

        //
    }

    private fun saveJournal() {
        val title : String = binding.postTitleEt.text.toString().trim()
        val thoughts : String = binding.postDescriptionEt.text.toString().trim()

        binding.postProgressBar.visibility = View.VISIBLE

        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(thoughts) && imageUri != null){
            //Saving the path of images in storage
            //.../journal_images/our_image.png
            val filePath : StorageReference = storageReference
                .child("journal_images")
                .child("my_image_"+ Timestamp.now().seconds)

            //Uploading the images
            filePath.putFile(imageUri)
                .addOnSuccessListener {
                    filePath.downloadUrl.addOnSuccessListener {
                        var imageUri: String = it.toString()

                        //Creating the object of the journal
                    }
                }
        }
    }
}