package com.example.project_ipak_yuli_mobile.data.source.remote.payments

import com.example.project_ipak_yuli_mobile.domain.source.remote.payments.PaymentsRemoteDataSource
import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.source.remote.api.IpakYuliApiService
import javax.inject.Inject

class PaymentsRemoteDataSourceImpl @Inject constructor(
    private val ipakYuliApiService: IpakYuliApiService
) : PaymentsRemoteDataSource {
    override suspend fun fetchPayments(): PaymentsDataResponseDto {
        val response = ipakYuliApiService.fetchPayments()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }
}