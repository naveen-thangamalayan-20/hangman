package com.example.hangman.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.hangman.model.GameState

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState

    fun onGuess(letter: Char) {
        val current = _uiState.value
        if (current.isGameOver || current.allGuesses.contains(letter)) return

        if (letter in current.wordToGuess) {
            _uiState.value = current.copy(
                correctGuesses = current.correctGuesses + letter
            )
        } else {
            _uiState.value = current.copy(
                wrongGuesses = current.wrongGuesses + letter,
                lives = current.lives - 1
            )
        }
    }

    fun resetGame() {
        _uiState.value = GameState() // For simplicity, always reset to "COMPOSE"
    }
}
