package com.example.userprofilemanagement.di

import android.content.Context
import com.example.userprofilemanagement.data.database.AppDatabase
import com.example.userprofilemanagement.data.model.dao.UserProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)

    }


    @Provides
    fun provideUserProfileDao(appDatabase: AppDatabase) : UserProfileDao{
        return appDatabase.userProfileDao()

    }

}