package com.example.hangman.model

data class GameState(
    val wordToGuess: String = "COMPOSE",
    val correctGuesses: Set<Char> = emptySet(),
    val wrongGuesses: Set<Char> = emptySet(),
    val lives: Int = 6,
) {
    val allGuesses = correctGuesses + wrongGuesses
    val isWon = wordToGuess.all { correctGuesses.contains(it) }
    val isGameOver = lives <= 0 || isWon
}
