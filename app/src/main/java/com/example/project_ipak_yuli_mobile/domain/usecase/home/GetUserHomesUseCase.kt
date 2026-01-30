package com.example.project_ipak_yuli_mobile.domain.usecase.home

import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.domain.repository.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserHomesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Flow<Result<List<UserHome>>> {
        return homeRepository.getUserHomes()
    }
}