package com.example.project_ipak_yuli_mobile.domain.usecase.home

import com.example.project_ipak_yuli_mobile.domain.repository.home.HomeRepository
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsefulOffersUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Flow<Result<List<UsefulOffer>>> {
        return homeRepository.getUsefulOffers()
    }
}