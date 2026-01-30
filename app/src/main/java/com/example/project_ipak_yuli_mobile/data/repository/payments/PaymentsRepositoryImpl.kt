package com.example.project_ipak_yuli_mobile.data.repository.payments

import com.example.project_ipak_yuli_mobile.domain.source.remote.payments.PaymentsRemoteDataSource
import com.example.project_ipak_yuli_mobile.domain.repository.payments.PaymentsRepository
import com.example.project_ipak_yuli_mobile.domain.model.payment.Payment
import com.example.project_ipak_yuli_mobile.data.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(
    private val paymentsRemoteDataSource: PaymentsRemoteDataSource
) : PaymentsRepository {
    override suspend fun getPayments(): Flow<Result<List<Payment>>> = flow {
        try {
            val result = paymentsRemoteDataSource.fetchPayments()
            val data = result.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}