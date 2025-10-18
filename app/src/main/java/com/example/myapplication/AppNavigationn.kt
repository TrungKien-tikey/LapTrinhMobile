package com.example.myapplication

import WelcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigationn() {
    val navController = rememberNavController()

    // BƯỚC 1: Đổi điểm bắt đầu thành "welcome"
    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") {
            // Giả sử hàm WelcomeScreen của bạn ở file khác
            WelcomeScreen(onReadyClick = {
                // Khi nhấn "I'm ready", chuyển đến màn hình "root" (thí nghiệm)
                navController.navigate("root")
            })
        }

        // Màn hình 1 (bây giờ là màn hình thứ 2): Root (Welcome)
        composable("root") {
            RootScreen(
                onNavigateToLazyColumn = { navController.navigate("lazy_list") },
                onNavigateToColumn = { navController.navigate("bad_list") }
            )
        }

        // Màn hình 2: Danh sách dùng LazyColumn (Chạy tốt)
        composable("lazy_list") {
            ListScreen(
                isLazy = true, // Báo cho màn hình dùng LazyColumn
                onItemClick = { navController.navigate("detail") },
                onBackClick = { navController.popBackStack() }
            )
        }

        // Màn hình 3: Danh sách dùng Column (Sẽ Crash)
        composable("bad_list") {
            ListScreen(
                isLazy = false, // Báo cho màn hình dùng Column
                onItemClick = { navController.navigate("detail") },
                onBackClick = { navController.popBackStack() }
            )
        }

        // Màn hình 4: Chi tiết
        composable("detail") {
            DetailScreen(
                onBackToRoot = {
                    // Xóa tất cả các màn hình trước đó và quay về "root"
                    navController.popBackStack("welcome", inclusive = false)
                },
                onBackToList = {
                    navController.popBackStack() // Chỉ quay lại 1 bậc
                }
            )
        }
    }
}