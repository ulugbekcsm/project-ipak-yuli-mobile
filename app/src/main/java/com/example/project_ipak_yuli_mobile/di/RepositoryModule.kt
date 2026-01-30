package com.example.project_ipak_yuli_mobile.di

import com.example.project_ipak_yuli_mobile.data.repository.services.ServicesRepositoryImpl
import com.example.project_ipak_yuli_mobile.domain.repository.services.ServicesRepository
import com.example.project_ipak_yuli_mobile.data.repository.cards.CardsRepositoryImpl
import com.example.project_ipak_yuli_mobile.domain.repository.cards.CardsRepository
import com.example.project_ipak_yuli_mobile.data.repository.home.HomeRepositoryImpl
import com.example.project_ipak_yuli_mobile.data.repository.payments.PaymentsRepositoryImpl
import com.example.project_ipak_yuli_mobile.domain.repository.home.HomeRepository
import com.example.project_ipak_yuli_mobile.domain.repository.payments.PaymentsRepository
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Binds

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        impl: HomeRepositoryImpl
    ) : HomeRepository

    @Binds
    @Singleton
    abstract fun bindCardsRepository(
        impl: CardsRepositoryImpl
    ) : CardsRepository

    @Binds
    @Singleton
    abstract fun bindServicesRepository(
        impl: ServicesRepositoryImpl
    ) : ServicesRepository

    @Binds
    @Singleton
    abstract fun bindPaymentsRepository(
        impl: PaymentsRepositoryImpl
    ) : PaymentsRepository
}