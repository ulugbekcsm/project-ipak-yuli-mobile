package com.example.project_ipak_yuli_mobile.di

import com.example.project_ipak_yuli_mobile.data.source.remote.api.IpakYuliApiService
import retrofit2.converter.gson.GsonConverterFactory
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import dagger.Provides
import dagger.Module

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideIpakYuliRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.3.123:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideIpakYuliApiService(retrofit: Retrofit): IpakYuliApiService {
        return retrofit.create(IpakYuliApiService::class.java)
    }
}