package com.example.project_ipak_yuli_mobile.domain.usecase.services

import com.example.project_ipak_yuli_mobile.domain.repository.services.ServicesRepository
import com.example.project_ipak_yuli_mobile.domain.model.service.Service
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val servicesRepository: ServicesRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Service>>> {
        return servicesRepository.getServices()
    }
}