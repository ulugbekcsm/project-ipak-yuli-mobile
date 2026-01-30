package com.example.project_ipak_yuli_mobile.domain.repository.home

import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getUserHomes(): Flow<Result<List<UserHome>>>
    suspend fun getBankingServices(): Flow<Result<List<BankingService>>>
    suspend fun getUsefulOffers(): Flow<Result<List<UsefulOffer>>>
    suspend fun getUserTransfers(): Flow<Result<List<UserTransfer>>>
    suspend fun getUserCards(): Flow<Result<List<UserCard>>>
}