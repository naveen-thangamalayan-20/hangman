package com.example.hangmangame.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HangmanDrawing(wrongGuesses: Int) {
    val lineColor = Color.Black
    val strokeWidth = 8f

    Box(modifier = Modifier.size(150.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Gallows
            drawLine(lineColor, Offset(0f, size.height), Offset(size.width, size.height), strokeWidth)
            drawLine(lineColor, Offset(size.width / 4, 0f), Offset(size.width / 4, size.height), strokeWidth)
            drawLine(lineColor, Offset(size.width / 4, 0f), Offset(size.width * 0.75f, 0f), strokeWidth)
            drawLine(lineColor, Offset(size.width * 0.75f, 0f), Offset(size.width * 0.75f, size.height * 0.2f), strokeWidth)
        }

        // Animated Body Parts
        BodyPart(visible = wrongGuesses >= 1) { // Head
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(lineColor, radius = 20f, center = Offset(size.width * 0.75f, size.height * 0.25f))
            }
        }
        BodyPart(visible = wrongGuesses >= 2) { // Body
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    lineColor,
                    Offset(size.width * 0.75f, size.height * 0.3f),
                    Offset(size.width * 0.75f, size.height * 0.5f),
                    strokeWidth
                )
            }
        }
        BodyPart(visible = wrongGuesses >= 3) { // Left Arm
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    lineColor,
                    Offset(size.width * 0.75f, size.height * 0.35f),
                    Offset(size.width * 0.65f, size.height * 0.4f),
                    strokeWidth
                )
            }
        }
        BodyPart(visible = wrongGuesses >= 4) { // Right Arm
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    lineColor,
                    Offset(size.width * 0.75f, size.height * 0.35f),
                    Offset(size.width * 0.85f, size.height * 0.4f),
                    strokeWidth
                )
            }
        }
        BodyPart(visible = wrongGuesses >= 5) { // Left Leg
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    lineColor,
                    Offset(size.width * 0.75f, size.height * 0.5f),
                    Offset(size.width * 0.65f, size.height * 0.6f),
                    strokeWidth
                )
            }
        }
        BodyPart(visible = wrongGuesses >= 6) { // Right Leg
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    lineColor,
                    Offset(size.width * 0.75f, size.height * 0.5f),
                    Offset(size.width * 0.85f, size.height * 0.6f),
                    strokeWidth
                )
            }
        }
    }
}

@Composable
fun BodyPart(visible: Boolean, content: @Composable () -> Unit) {
    AnimatedVisibility(visible = visible, enter = fadeIn()) {
        content()
    }
}
