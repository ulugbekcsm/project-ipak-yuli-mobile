package com.example.project_ipak_yuli_mobile.domain.usecase.payments

import com.example.project_ipak_yuli_mobile.domain.repository.payments.PaymentsRepository
import com.example.project_ipak_yuli_mobile.domain.model.payment.Payment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(
    private val paymentsRepository: PaymentsRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Payment>>> {
        return paymentsRepository.getPayments()
    }
}