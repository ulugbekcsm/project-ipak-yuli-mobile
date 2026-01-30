package com.example.project_ipak_yuli_mobile.domain.source.remote.services

import com.example.project_ipak_yuli_mobile.data.model.service.ServicesDataResponseDto

interface ServicesRemoteDataSource {
    suspend fun fetchServices(): ServicesDataResponseDto
}