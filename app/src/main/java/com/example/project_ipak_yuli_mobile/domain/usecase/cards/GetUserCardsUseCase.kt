package com.example.project_ipak_yuli_mobile.domain.usecase.cards

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.repository.cards.CardsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserCardsUseCase @Inject constructor(
    private val cardsRepository: CardsRepository
) {
    suspend operator fun invoke(): Flow<Result<List<UserCard>>> {
        return cardsRepository.getUserCards()
    }
}