package com.example.myapplication
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RootScreen(
    onNavigateToLazyColumn: () -> Unit,
    onNavigateToColumn: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bạn có thể thêm Image và Text ở đây
        Text("Thí nghiệm Column vs LazyColumn", modifier = Modifier.padding(16.dp))

        // Nút 1: Chạy LazyColumn (sẽ hoạt động)
        Button(onClick = onNavigateToLazyColumn) {
            Text("Test LazyColumn (1.000.000 items) - Sẽ chạy tốt")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Nút 2: Chạy Column (sẽ bị crash)
        Button(
            onClick = onNavigateToColumn,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Test Column (1.000.000 items) - Sẽ CRASH")
        }
    }
}