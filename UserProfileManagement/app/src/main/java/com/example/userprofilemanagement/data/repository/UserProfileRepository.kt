package com.example.userprofilemanagement.data.repository

import android.content.Context
import com.example.userprofilemanagement.data.database.AppDatabase
import com.example.userprofilemanagement.data.model.UserProfile
import com.example.userprofilemanagement.data.model.dao.UserProfileDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfileRepository @Inject constructor(private val userProfileDao: UserProfileDao) {

    //private val userProfileDao = AppDatabase.getDatabase(context).userProfileDao()

    //Function to insert User Profile
    suspend fun insertUserProfile(userProfile: UserProfile): Long {
        return withContext(Dispatchers.IO){
            userProfileDao.insertUserProfile(userProfile)
        }
    }

    //get all user profiles
    suspend fun getAllUserProfiles(): List<UserProfile> {

        return withContext(Dispatchers.IO){
            userProfileDao.getAllUserProfiles()
        }
    }

    //write th logic for delete user profile
    suspend fun deleteUserProfile(id: Long): Int {
        return withContext(Dispatchers.IO){
            userProfileDao.deleteUserProfile(id)
        }
    }



}

//Dispatchers
/*
1. Dispatcher.Main->Main thread
2. Dispatcher.IO->Background thread
3. Dispatcher.Default->CPU intensive Operations
4. Dispatcher.Unconfined-> Not confined to any specific thread but runs on the current thread
 */