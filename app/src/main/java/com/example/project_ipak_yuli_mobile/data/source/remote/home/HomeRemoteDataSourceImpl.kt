package com.example.project_ipak_yuli_mobile.data.source.remote.home

import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServicesResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usertransfer.UserTransfersDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usefuloffer.UsefulOffersDataResponseDto
import com.example.project_ipak_yuli_mobile.domain.source.remote.home.HomeRemoteDataSource
import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.userhome.UserHomesDataResponseDto
import com.example.project_ipak_yuli_mobile.data.source.remote.api.IpakYuliApiService
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val ipakYuliApiService: IpakYuliApiService
) : HomeRemoteDataSource {
    override suspend fun fetchUserHomes(): UserHomesDataResponseDto {
        val response = ipakYuliApiService.fetchUserHomes()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }

    override suspend fun fetchBankingServices(): BankingServicesResponseDto {
        val response = ipakYuliApiService.fetchBankingServices()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }

    override suspend fun fetchUsefulOffers(): UsefulOffersDataResponseDto {
        val response = ipakYuliApiService.fetchUsefulOffers()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()} ${response.message()}")
        }
    }

    override suspend fun fetchUserTransfers(): UserTransfersDataResponseDto {
        val response = ipakYuliApiService.fetchUserTransfers()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }

    override suspend fun fetchUserCards(): UserCardsDataResponseDto {
        val response = ipakYuliApiService.fetchUserCards()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }
}