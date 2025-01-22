package com.example.userprofilemanagement

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val tv = findViewById<TextView>(R.id.textview)
        tv.text = "Welcome to Android Training"

//        findViewById<Button>(R.id.buttonOpenUserProfilePage)
//            .setOnClickListener {
//                startActivity(Intent(this, UserProfileActivity::class.java))
//            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_add_item -> {
                startActivity(Intent(this, UserProfileActivity::class.java))
                true
            }

            R.id.action_settings -> {
                Toast.makeText(applicationContext, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}