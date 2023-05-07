package com.pmt.di

import android.app.Application
import androidx.room.Room
import com.pmt.R
import com.pmt.data.PmtDatabase
import com.pmt.data.log.LogDao
import com.pmt.data.project.ProjectDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun providePmtDatabase(application: Application): PmtDatabase {
        return Room
            .databaseBuilder(
                application,
                PmtDatabase::class.java,
                application.getString(R.string.database)
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProjectDao(appDatabase: PmtDatabase): ProjectDao {
        return appDatabase.projectDao()
    }

    @Provides
    @Singleton
    fun provideLogDao(appDatabase: PmtDatabase): LogDao {
        return appDatabase.logDao()
    }
}