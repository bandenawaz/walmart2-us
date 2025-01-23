package com.example.userprofilemanagement.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userName: String,
    val userEmail: String
)
