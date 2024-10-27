package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "search_results") {
        composable("search_results") {
            val viewModel = SearchResultViewModel()
            SearchResultScreen(viewModel = viewModel, onItemClick = { id ->
                navController.navigate("listing_detail/$id")
            })
        }
        composable("listing_detail/{propertyId}") { backStackEntry ->
            val propertyId = backStackEntry.arguments?.getString("propertyId") ?: return@composable
            val viewModel = ListingDetailViewModel()
            ListingDetailScreen(viewModel = viewModel, propertyId = propertyId)
        }
    }
}
