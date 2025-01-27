package com.example.eventplanner.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventplanner.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //intialise the firebase auth
        auth = FirebaseAuth.getInstance()

        //initialise all the widgets
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        loginButton.setOnClickListener{
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()
            loginUSer(email, password)

            emailEditText.setText(null)
            passwordEditText.setText(null)
        }

        registerButton.setOnClickListener{
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()

            createUser(email, password)
            emailEditText.setText(null)
            passwordEditText.setText(null)

        }


    }

    private fun createUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()


                }else{
                    Toast.makeText(this, "Registration Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun loginUSer(email: String, password: String) {

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "User Authenticated Successfully", Toast.LENGTH_SHORT).show()
                    //Navigate to Home Screen
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    Toast.makeText(this, "Authentication Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }
}