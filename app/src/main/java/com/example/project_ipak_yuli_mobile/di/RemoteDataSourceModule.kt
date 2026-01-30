package com.example.project_ipak_yuli_mobile.di

import com.example.project_ipak_yuli_mobile.data.source.remote.services.ServicesRemoteDataSourceImpl
import com.example.project_ipak_yuli_mobile.domain.source.remote.services.ServicesRemoteDataSource
import com.example.project_ipak_yuli_mobile.data.source.remote.cards.CardsRemoteDataSourceImpl
import com.example.project_ipak_yuli_mobile.domain.source.remote.cards.CardsRemoteDataSource
import com.example.project_ipak_yuli_mobile.data.source.remote.home.HomeRemoteDataSourceImpl
import com.example.project_ipak_yuli_mobile.data.source.remote.payments.PaymentsRemoteDataSourceImpl
import com.example.project_ipak_yuli_mobile.domain.source.remote.home.HomeRemoteDataSource
import com.example.project_ipak_yuli_mobile.domain.source.remote.payments.PaymentsRemoteDataSource
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Binds

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindHomeRemoteDataSource(
        impl: HomeRemoteDataSourceImpl
    ) : HomeRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindCardsRemoteDataSource(
        impl: CardsRemoteDataSourceImpl
    ) : CardsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindServicesRemoteDataSource(
        impl: ServicesRemoteDataSourceImpl
    ) : ServicesRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindPaymentsRemoteDataSource(
        impl: PaymentsRemoteDataSourceImpl
    ) : PaymentsRemoteDataSource
}