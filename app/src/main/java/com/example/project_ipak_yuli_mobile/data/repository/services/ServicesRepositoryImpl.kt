package com.example.project_ipak_yuli_mobile.data.repository.services

import com.example.project_ipak_yuli_mobile.domain.source.remote.services.ServicesRemoteDataSource
import com.example.project_ipak_yuli_mobile.domain.repository.services.ServicesRepository
import com.example.project_ipak_yuli_mobile.domain.model.service.Service
import com.example.project_ipak_yuli_mobile.data.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private val servicesRemoteDataSource: ServicesRemoteDataSource
) : ServicesRepository {
    override suspend fun getServices(): Flow<Result<List<Service>>> = flow {
        try {
            val result = servicesRemoteDataSource.fetchServices()
            val data = result.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}