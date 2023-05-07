package com.pmt.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.pmt.R
import com.pmt.network.AuthApiService
import com.pmt.network.TokenManager
import com.pmt.network.WorklogApiService
import com.pmt.network.authenticator.AuthAuthenticator
import com.pmt.network.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_store")


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager = TokenManager(context)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        authAuthenticator: AuthAuthenticator,
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .authenticator(authAuthenticator)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(tokenManager: TokenManager): AuthInterceptor =
        AuthInterceptor(tokenManager)

    @Singleton
    @Provides
    fun provideAuthAuthenticator(tokenManager: TokenManager): AuthAuthenticator =
        AuthAuthenticator(tokenManager)


    private fun getRetrofitBuilder(url: String): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())

    @Singleton
    @Provides
    fun provideAuthAPIService(retrofit: Retrofit.Builder): AuthApiService{
        var retrofit = getRetrofitBuilder(R.string.auth_url.toString())
        return retrofit
            .build()
            .create(AuthApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideWorklogAPIService(okHttpClient: OkHttpClient, retrofit: Retrofit.Builder): WorklogApiService{
        var retrofit = getRetrofitBuilder(R.string.worklog_url.toString())
        return retrofit
                .client(okHttpClient)
                .build()
                .create(WorklogApiService::class.java)
    }
}