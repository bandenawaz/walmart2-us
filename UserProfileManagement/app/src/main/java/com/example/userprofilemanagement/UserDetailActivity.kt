package com.example.userprofilemanagement

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val textViewUDName = findViewById<TextView>(R.id.textViewUDName)
        val textViewUDEmail = findViewById<TextView>(R.id.textViewUDEmail)

        textViewUDName.text = intent.getStringExtra("userName")
        textViewUDEmail.text = intent.getStringExtra("userEmail")


    }
}