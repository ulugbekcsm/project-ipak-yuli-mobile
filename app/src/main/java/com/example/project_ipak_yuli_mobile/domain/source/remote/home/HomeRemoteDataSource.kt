package com.example.project_ipak_yuli_mobile.domain.source.remote.home

import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServicesResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usefuloffer.UsefulOffersDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.userhome.UserHomesDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usertransfer.UserTransfersDataResponseDto

interface HomeRemoteDataSource {
    suspend fun fetchUserHomes(): UserHomesDataResponseDto
    suspend fun fetchBankingServices(): BankingServicesResponseDto
    suspend fun fetchUsefulOffers(): UsefulOffersDataResponseDto
    suspend fun fetchUserTransfers(): UserTransfersDataResponseDto
    suspend fun fetchUserCards(): UserCardsDataResponseDto
}