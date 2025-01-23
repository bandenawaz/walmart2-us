package com.example.userprofilemanagement.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofilemanagement.data.model.UserProfile
import com.example.userprofilemanagement.data.model.dao.UserProfileDao

@Database(entities = [UserProfile::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userProfileDao(): UserProfileDao

    companion object{
        @Volatile
        private var INSTANCE:AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_profile_database"

                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}