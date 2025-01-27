package com.example.eventplanner.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eventplanner.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AddEventActivity : AppCompatActivity() {

    private val  firestore = FirebaseFirestore.getInstance()

    private lateinit var etTitle: EditText
    private lateinit var etDate: EditText
    private lateinit var etTime: EditText
    private lateinit var etLocation: EditText
    private lateinit var etDescription: EditText
    private lateinit var btnSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        inialiseViews()

        //handle Date Picker
        etDate.setOnClickListener{
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, {_, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                etDate.setText(formattedDate)
            },year,month,day).show()

        }

        //handle Time Picker
        etTime.setOnClickListener{
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(this, {_, selectedHour, selectedMinute ->
                val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                etTime.setText(formattedTime)
            },hour,minute,false).show()

        }

        btnSave.setOnClickListener {
            saveEventToFireStore()
        }


    }

    fun inialiseViews(){
        etTitle = findViewById(R.id.editTextEventTitle)
        etDate = findViewById(R.id.editTextEventDate)
        etTime = findViewById(R.id.editTextEventTime)
        etLocation = findViewById(R.id.editTextEventLocation)
        etDescription = findViewById(R.id.editTextEventDescription)
        btnSave = findViewById(R.id.btnSaveEvent)

    }

    private fun saveEventToFireStore() {
        val title = etTitle.text.toString()
        val date = etDate.text.toString()
        val time = etTime.text.toString()
        val location = etLocation.text.toString()
        val description = etDescription.text.toString()

        //lets do some validation
        if (title.isEmpty() || date.isEmpty() || time.isEmpty() || location.isEmpty() || description.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }

        val event = hashMapOf(
            "title" to title,
            "date" to date,
            "time" to time,
            "location" to location,
            "description" to description
        )

        firestore.collection("events")
            .add(event)
            .addOnSuccessListener {
                Toast.makeText(this, "Event Added Successfully", Toast.LENGTH_SHORT).show()
                //Go Back to Home Screen
                finish()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Failed to Save: ${it.message}", Toast.LENGTH_SHORT).show()
                //finish()
            }

    }

}