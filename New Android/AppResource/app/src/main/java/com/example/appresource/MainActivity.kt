
package com.example.appresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.addgame -> Toast.makeText(this, "Add Game Selected", Toast.LENGTH_SHORT).show()
            R.id.dgame -> Toast.makeText(this, "Delete Game Selected", Toast.LENGTH_SHORT).show()
            R.id.ngame -> Toast.makeText(this, "New Game Selected", Toast.LENGTH_SHORT).show()
            R.id.qgame -> Toast.makeText(this, "Quit Game Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}