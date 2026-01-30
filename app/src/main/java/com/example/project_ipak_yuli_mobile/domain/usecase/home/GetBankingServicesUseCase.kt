package com.example.project_ipak_yuli_mobile.domain.usecase.home

import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.repository.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBankingServicesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Flow<Result<List<BankingService>>> {
        return homeRepository.getBankingServices()
    }
}