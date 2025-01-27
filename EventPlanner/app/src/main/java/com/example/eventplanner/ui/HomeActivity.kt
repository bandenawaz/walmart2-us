package com.example.eventplanner.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventplanner.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var btnAddEvent: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvEvents = findViewById(R.id.rvEvents)
        btnAddEvent = findViewById(R.id.btnAddEvent)

        //Setup the recyclerview
        rvEvents.layoutManager = LinearLayoutManager(this)
        rvEvents.adapter = EventAdapter(getDummyEvnts)

    }
}