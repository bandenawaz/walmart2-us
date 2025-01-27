package com.example.eventplanner.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventplanner.R
import com.example.eventplanner.adapter.EventAdapter
import com.example.eventplanner.model.Event
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var btnAddEvent: FloatingActionButton
    private val  firestore = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvEvents = findViewById(R.id.rvEvents)
        btnAddEvent = findViewById(R.id.btnAddEvent)

        //Setup the recyclerview
        rvEvents.layoutManager = LinearLayoutManager(this)
        rvEvents.adapter = EventAdapter(getDummyEvents())

        //Lets Navigate to AddEvent Screen
        btnAddEvent.setOnClickListener{
            startActivity(Intent(this, AddEventActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        loadDataFromFirestore()
    }

    //lets create some dummy events
    private fun getDummyEvents(): List<Event> {
        return listOf(
            Event("Meeting", "2025-01-15", "10:00 AM", "Conference Room A", "Discuss project updates and Planning Session"),
            Event("Birthday Party", "2025-02-15", "07:00 PM", "Vivke's House", "Vivek's 28th Birthday")

        )
    }

    private fun loadDataFromFirestore(){
        firestore.collection("events")
            .get()
            .addOnSuccessListener { result ->
                val events = result.map { doc ->
                    Event(
                        doc.getString("title") ?: "",
                        doc.getString("date") ?: "",
                        doc.getString("time") ?: "",
                        doc.getString("location") ?: "",
                        doc.getString("description") ?: ""
                    )
                }

                rvEvents.adapter = EventAdapter(events)
            }
            .addOnFailureListener{
                Toast.makeText(this, "Failed to load data: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}