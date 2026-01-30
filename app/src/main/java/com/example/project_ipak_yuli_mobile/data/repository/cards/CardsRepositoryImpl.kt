package com.example.project_ipak_yuli_mobile.data.repository.cards

import com.example.project_ipak_yuli_mobile.data.mapper.toDomain
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.repository.cards.CardsRepository
import com.example.project_ipak_yuli_mobile.domain.source.remote.cards.CardsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val cardsRemoteDataSource: CardsRemoteDataSource
) : CardsRepository {
    override suspend fun getUserCards(): Flow<Result<List<UserCard>>> = flow {
        try {
            val response = cardsRemoteDataSource.fetchUserCards()
            val data = response.data.map { it.toDomain() }
            emit(Result.success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}