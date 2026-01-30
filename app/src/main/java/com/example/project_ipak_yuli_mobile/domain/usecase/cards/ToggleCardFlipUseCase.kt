package com.example.project_ipak_yuli_mobile.domain.usecase.cards

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import javax.inject.Inject

class ToggleCardFlipUseCase @Inject constructor() {
    operator fun invoke(cards: List<UserCard>, cardId: String): List<UserCard> {
        return cards.map { card ->
            if (card.id == cardId) card.copy(isFlipped = !card.isFlipped)
            else card
        }
    }
}