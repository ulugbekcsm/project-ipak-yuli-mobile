package com.example.project_ipak_yuli_mobile.data.source.remote.services

import com.example.project_ipak_yuli_mobile.domain.source.remote.services.ServicesRemoteDataSource
import com.example.project_ipak_yuli_mobile.data.model.service.ServicesDataResponseDto
import com.example.project_ipak_yuli_mobile.data.source.remote.api.IpakYuliApiService
import javax.inject.Inject

class ServicesRemoteDataSourceImpl @Inject constructor(
    private val ipakYuliApiService: IpakYuliApiService
) : ServicesRemoteDataSource {
    override suspend fun fetchServices(): ServicesDataResponseDto {
        val response = ipakYuliApiService.fetchServices()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }
}