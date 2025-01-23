package com.example.userprofilemanagement.data.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.userprofilemanagement.data.model.UserProfile


@Dao
interface UserProfileDao {

    @Insert
    suspend fun insertUserProfile(userProfile: UserProfile): Long


    @Query("SELECT * FROM user_profiles")
    suspend fun getAllUserProfiles(): List<UserProfile>

    @Query("DELETE FROM user_profiles WHERE id = :id")
    suspend fun deleteUserProfile(id: Long): Int

}