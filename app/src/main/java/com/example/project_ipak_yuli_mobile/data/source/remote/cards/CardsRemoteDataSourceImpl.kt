package com.example.project_ipak_yuli_mobile.data.source.remote.cards

import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.source.remote.api.IpakYuliApiService
import com.example.project_ipak_yuli_mobile.domain.source.remote.cards.CardsRemoteDataSource
import javax.inject.Inject

class CardsRemoteDataSourceImpl @Inject constructor(
    private val ipakYuliApiService: IpakYuliApiService
) : CardsRemoteDataSource {
    override suspend fun fetchUserCards(): UserCardsDataResponseDto {
        val response = ipakYuliApiService.fetchUserCards()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body else throw Exception("Response body is null")
        } else {
            throw Exception("HTTP ${response.code()}: ${response.message()}")
        }
    }
}