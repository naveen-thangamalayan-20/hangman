package com.example.hangman.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hangman.viewmodel.GameViewModel
import com.example.hangman.ui.components.Keyboard
import com.example.hangmangame.ui.components.HangmanDrawing

@Composable
fun GameScreen(viewModel: GameViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hangman", style = MaterialTheme.typography.headlineLarge)
        HangmanDrawing(state.wrongGuesses.size)
        Row {
            state.wordToGuess.forEach { letter ->
                Text(
                    if (state.correctGuesses.contains(letter)) "$letter " else "_ ",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        Text("Wrong guesses: ${state.wrongGuesses.joinToString(" ")}")

        Text("Lives left: ${state.lives}")

        if (state.isGameOver) {
            Text(if (state.isWon) "You Won!" else "Game Over! The correct answer is:" + state.wordToGuess)
            Button(onClick = { viewModel.resetGame() }) {
                Text("Play Again")
            }
        } else {
            Keyboard(onKeyPress = viewModel::onGuess, guessed = state.allGuesses)
        }
    }
}
