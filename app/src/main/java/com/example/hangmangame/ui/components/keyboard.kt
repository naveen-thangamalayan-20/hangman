package com.example.hangman.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Keyboard(onKeyPress: (Char) -> Unit, guessed: Set<Char>) {
    val rows = listOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        rows.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEach { c ->
                    Button(
                        onClick = { onKeyPress(c) },
                        enabled = !guessed.contains(c),
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = c.toString(),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
