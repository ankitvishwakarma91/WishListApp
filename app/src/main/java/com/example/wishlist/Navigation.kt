package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(Screen.HomeScreen.route){
            HomeView(navController = navController, viewModel = viewModel)
        }

        composable(Screen.AddScreen.route +  "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
            ){ entry->
            val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
//            val id = entry.arguments?.getLong("id") ?: 0L
            AddEditDetailsView(id = id, viewModel = viewModel, navController = navController)
        }

    }
}