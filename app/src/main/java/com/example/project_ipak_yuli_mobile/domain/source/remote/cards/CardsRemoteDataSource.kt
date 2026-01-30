package com.example.project_ipak_yuli_mobile.domain.source.remote.cards

import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardsDataResponseDto

interface CardsRemoteDataSource {
    suspend fun fetchUserCards(): UserCardsDataResponseDto
}