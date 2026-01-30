package com.example.project_ipak_yuli_mobile.domain.repository.services

import com.example.project_ipak_yuli_mobile.domain.model.service.Service
import kotlinx.coroutines.flow.Flow

interface ServicesRepository {
    suspend fun getServices(): Flow<Result<List<Service>>>
}