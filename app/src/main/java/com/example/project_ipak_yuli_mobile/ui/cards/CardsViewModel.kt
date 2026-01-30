package com.example.project_ipak_yuli_mobile.ui.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_ipak_yuli_mobile.domain.usecase.cards.GetUserCardsUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.cards.ToggleCardFlipUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.cards.UpdateScreenTabsUseCase
import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val getUserCardsUseCase: GetUserCardsUseCase,
    private val updateScreenTabsUseCase: UpdateScreenTabsUseCase,
    private val toggleCardFlipUseCase: ToggleCardFlipUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CardsUiState())
    val uiState: StateFlow<CardsUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<CardsEvent>()
    val event: SharedFlow<CardsEvent> = _event.asSharedFlow()

    init {
        refreshCardsScreen()
    }

    fun refreshCardsScreen() {
        viewModelScope.launch {
            startRefreshing()
            _uiState.update { it.copy(isLoading = true) }

            val job = async { loadUserCards() }
            job.await()

            stopRefreshing()
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private suspend fun loadUserCards() {
        getUserCardsUseCase().collect { result ->
            result.onSuccess { cards ->
                val initialTabs = CardTab.categories
                val tabs = updateScreenTabsUseCase(cards, initialTabs)

                _uiState.update {
                    it.copy(
                        userCards = cards,
                        cardTabs = tabs
                    )
                }
            }.onFailure { throwable ->
                _event.emit(CardsEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private fun startRefreshing() {
        _uiState.update { it.copy(isUserCardsRefreshing = true) }
    }

    private fun stopRefreshing() {
        _uiState.update { it.copy(isUserCardsRefreshing = false) }
    }

    fun showCardActionSheet() {
        _uiState.update { it.copy(isCardActionSheetVisible = true) }
    }

    fun hideCardActionSheet() {
        _uiState.update { it.copy(isCardActionSheetVisible = false) }
    }

    fun toggleCompactMode() {
        _uiState.update {
            it.copy(isUserCardsCompactMode = !it.isUserCardsCompactMode)
        }
    }

    fun toggleCardFlip(cardId: String) {
        val updatedCards = toggleCardFlipUseCase(_uiState.value.userCards, cardId)
        val updatedTabs = updateScreenTabsUseCase(updatedCards, _uiState.value.cardTabs)

        _uiState.update {
            it.copy(
                userCards = updatedCards,
                cardTabs = updatedTabs
            )
        }
    }

    fun changeCardCategoryTab(index: Int) {
        _uiState.update {
            it.copy(
                cardTabs = it.cardTabs.map { tab ->
                    tab.copy(isSelected = tab.index == index)
                }
            )
        }
    }
}