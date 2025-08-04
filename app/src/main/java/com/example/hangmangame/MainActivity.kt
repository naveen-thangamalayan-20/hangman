package com.example.hangmangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hangman.ui.GameScreen
import com.example.hangman.ui.HomeScreen
import com.example.hangmangame.ui.theme.HangmanGameTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HangmanGameTheme {
                val navController = rememberNavController()
//
//                var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
//
//                Crossfade(targetState = currentScreen, label = "screen_transition") { screen ->
//                    when (screen) {
//                        is Screen.Home -> HomeScreen(onPlayClick = { currentScreen = Screen.Game })
//                        is Screen.Game -> GameScreen()
//                    }
//                }

//                NavHost(navController = navController, startDestination = "home") {
//                    composable("home") { HomeScreen(navController) }
//                    composable("game") { GameScreen() }
//                }

                AnimatedNavHost(
                    navController = navController,
                    startDestination = "home",
                    enterTransition = { fadeIn(animationSpec = tween(300)) },
                    exitTransition = { fadeOut(animationSpec = tween(300)) },
                    popEnterTransition = { fadeIn(animationSpec = tween(300)) },
                    popExitTransition = { fadeOut(animationSpec = tween(300)) }
                ) {
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("game") {
                        GameScreen()
                    }
                }
            }
        }
    }
}

