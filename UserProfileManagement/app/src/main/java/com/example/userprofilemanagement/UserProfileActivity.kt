package com.example.userprofilemanagement

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserProfileActivity : AppCompatActivity() {

    private val userList = mutableListOf<UserProfile>()
    private lateinit var adapter: UserProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val etName = findViewById<EditText>(R.id.editTextName)
        val etEmail = findViewById<EditText>(R.id.editTextEmail)
        val saveBtn = findViewById<Button>(R.id.buttonSave)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewUserProfiles)

        adapter = UserProfileAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //Get the SharedPreference instance
        val sharedPreferences = getSharedPreferences("user_profile", Context.MODE_PRIVATE)

        //lets load the saved user profile data
        val savedName = sharedPreferences.getString("name", "")
        val savedEmail = sharedPreferences.getString("email", "")

        etName.setText(savedName)
        etEmail.setText(savedEmail)

        saveBtn.setOnClickListener {

            val userName: String = etName.text.toString()
            val userEmail: String = etEmail.text.toString()

            //lets do some field validation
            if(userEmail.isNotEmpty() && userEmail.isNotEmpty()){
                saveUserProfile(userName, userEmail, sharedPreferences)

//                val intent = Intent(this, UserDetailActivity::class.java).apply {
//                    putExtra("userName", userName)
//                    putExtra("userEmail", userEmail)
//
//                }
//                startActivity(intent)
            }else{
                etName.error = "Please enter name"
                etEmail.error = "Please enter email"
                Toast.makeText(applicationContext, "Please enter both name and email", Toast.LENGTH_SHORT).show()
            }


            etEmail.setText(null)
            etName.setText(null)
            etName.requestFocus()
        }


    }

    private fun saveUserProfile(userName: String, email: String, sharedPreferences: SharedPreferences) {

        val editor = sharedPreferences.edit()
        editor.putString("name", userName)
        editor.putString("email", email)
        editor.apply()

        //lets add data to the recyclerview
        val userProfile = UserProfile(userName, email)
        userList.add(userProfile)
        adapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "Profile Saved: $userName, $email", Toast.LENGTH_SHORT).show()
    }
}