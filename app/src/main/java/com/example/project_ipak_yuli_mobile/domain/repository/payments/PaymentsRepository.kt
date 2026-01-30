package com.example.project_ipak_yuli_mobile.domain.repository.payments

import com.example.project_ipak_yuli_mobile.domain.model.payment.Payment
import kotlinx.coroutines.flow.Flow

interface PaymentsRepository {
    suspend fun getPayments(): Flow<Result<List<Payment>>>
}