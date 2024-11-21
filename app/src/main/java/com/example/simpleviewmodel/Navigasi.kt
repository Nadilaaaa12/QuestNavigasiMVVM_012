package com.example.simpleviewmodel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.simpleviewmodel.viewmodel.MahasiswaViewModel

enum class Halaman {
    Form,
    Data
}
@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {

    Scaffold { isPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isPadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {

        }
