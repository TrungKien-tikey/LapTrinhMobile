package com.example.myapplication

import WelcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        // Màn hình WelcomeScreen
        composable("welcome") {
            WelcomeScreen(onReadyClick = {
                navController.navigate("component_list")
            })
        }

        // Màn hình ComponentListScreen (đã cập nhật)
        composable("component_list") {
            ComponentListScreen(
                onTextClick = { navController.navigate("text_detail") },
                onImageClick = { navController.navigate("image_detail") },
                onTextFieldClick = { navController.navigate("textField_detail") },
                onPasswordFieldClick = { navController.navigate("passWordField_detail") },
                onRowLayoutClick = { navController.navigate("row_layout_detail") },
                onColumnLayoutClick = { navController.navigate("column_layout_detail") },
                onSelfExploreClick = { navController.navigate("self_explore_detail") }

            )
        }

        // Các màn hình chi tiết
        composable("text_detail") {
            TextDetailScreen(onBackClick = { navController.popBackStack() })
        }
        composable("image_detail") {
            ImageDetailScreen(onBackClick = { navController.popBackStack() })
        }
        composable("textField_detail") {
            TextFieldDetailScreen(onBackClick = { navController.popBackStack() })
        }
        composable("passWordField_detail") {
            PasswordFieldDetailScreen(onBackClick = { navController.popBackStack() })
        }
        composable("row_layout_detail") {
            RowLayoutScreen(onBackClick = { navController.popBackStack() })
        }
        composable("column_layout_detail") {
            ColumnLayoutDetailScreen(onBackClick = { navController.popBackStack() })
        }
        composable("self_explore_detail") {
            SelfExploreScreen(onBackClick = { navController.popBackStack() })
        }
    }
}