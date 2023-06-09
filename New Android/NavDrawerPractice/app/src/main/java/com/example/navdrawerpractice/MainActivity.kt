package com.example.navdrawerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(this@MainActivity,
        drawerLayout,
        R.string.open,
        R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView: NavigationView = findViewById(R.id.navView)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment(), it.title.toString())
            }
                R.id.settings -> {
                    replaceFragment(SettingsFragment(), it.title.toString())
                }

                R.id.message -> {
                    replaceFragment(MessageFragment(), it.title.toString())
                }

                R.id.notification -> {
                    replaceFragment(NotificationFragment(), it.title.toString())
                }

                R.id.login -> {
                    replaceFragment(LoginFragment(), it.title.toString())
                }
        }
            return@setNavigationItemSelectedListener true

    }


}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun replaceFragment(fragment: Fragment, title : String) {
        val fragManger: FragmentManager = supportFragmentManager
        val fragTrans: FragmentTransaction = fragManger.beginTransaction()
        fragTrans.replace(R.id.frameLayout, fragment)
        fragTrans.commit()

        drawerLayout.closeDrawers()
        setTitle(title)
    }

    }
