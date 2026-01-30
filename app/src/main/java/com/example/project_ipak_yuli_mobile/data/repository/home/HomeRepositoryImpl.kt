package com.example.project_ipak_yuli_mobile.data.repository.home

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.project_ipak_yuli_mobile.data.mapper.toDomain
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import com.example.project_ipak_yuli_mobile.domain.repository.home.HomeRepository
import com.example.project_ipak_yuli_mobile.domain.source.remote.home.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getUserHomes(): Flow<Result<List<UserHome>>> = flow {
        try {
            val response = homeRemoteDataSource.fetchUserHomes()
            val data = response.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getBankingServices(): Flow<Result<List<BankingService>>> = flow {
        try {
            val response = homeRemoteDataSource.fetchBankingServices()
            val data = response.data.services.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getUsefulOffers(): Flow<Result<List<UsefulOffer>>> = flow {
        try {
            val response = homeRemoteDataSource.fetchUsefulOffers()
            val data = response.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getUserTransfers(): Flow<Result<List<UserTransfer>>> = flow {
        try {
            val response = homeRemoteDataSource.fetchUserTransfers()
            val data = response.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getUserCards(): Flow<Result<List<UserCard>>> = flow {
        try {
            val response = homeRemoteDataSource.fetchUserCards()
            val data = response.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}