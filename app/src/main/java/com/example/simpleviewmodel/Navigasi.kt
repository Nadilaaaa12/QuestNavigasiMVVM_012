package com.example.simpleviewmodel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleviewmodel.model.ListGender
import com.example.simpleviewmodel.ui.theme.view.FormMahasiswaView
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
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isPadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listGender = ListGender.listJk.map { // Data JK dapat dari object
                            isi ->
                        konteks.resources.getString(isi)
                    },
                    onSubmitClick = {
                        viewModel.saveDataMhs(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name){

            }

        }
    }
}
