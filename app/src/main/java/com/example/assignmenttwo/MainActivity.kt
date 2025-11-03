package com.example.assignmenttwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignmenttwo.ui.theme.AssignmentTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTwoTheme {
                CoffeeApp()
            }
        }
    }
}

@Composable
fun CoffeeApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {
        composable("onboarding") {
            OnboardingScreen(
                onGetStarted = {
                    navController.navigate("coffee_detail")
                }
            )
        }
        
        composable("coffee_detail") {
            CoffeeDetailScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onBuyNow = {
                    navController.navigate("order")
                }
            )
        }
        
        composable("order") {
            OrderScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}