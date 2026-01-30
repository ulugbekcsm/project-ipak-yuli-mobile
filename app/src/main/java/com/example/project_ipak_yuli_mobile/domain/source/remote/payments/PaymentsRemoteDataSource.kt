package com.example.project_ipak_yuli_mobile.domain.source.remote.payments

import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentsDataResponseDto

interface PaymentsRemoteDataSource {
    suspend fun fetchPayments(): PaymentsDataResponseDto
}