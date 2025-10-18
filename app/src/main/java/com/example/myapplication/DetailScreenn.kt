package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    onBackToRoot: () -> Unit,
    onBackToList: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "\"The only way to do great work is to love what you do.\"",
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Nút BACK TO ROOT (theo yêu cầu bài tập)
        Button(onClick = onBackToRoot, modifier = Modifier.fillMaxWidth()) {
            Text("BACK TO ROOT")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nút BACK (quay lại danh sách)
        Button(onClick = onBackToList, modifier = Modifier.fillMaxWidth()) {
            Text("BACK TO LIST")
        }
    }
}