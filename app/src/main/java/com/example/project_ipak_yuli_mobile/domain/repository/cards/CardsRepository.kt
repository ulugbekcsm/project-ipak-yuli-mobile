package com.example.project_ipak_yuli_mobile.domain.repository.cards

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import kotlinx.coroutines.flow.Flow

interface CardsRepository {
    suspend fun getUserCards(): Flow<Result<List<UserCard>>>
}