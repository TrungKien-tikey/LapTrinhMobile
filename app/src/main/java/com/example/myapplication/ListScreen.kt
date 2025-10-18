package com.example.myapplication

import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    isLazy: Boolean,
    onItemClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(if (isLazy) "LazyColumn (Tốt)" else "Column (Lỗi)")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->

        // ---- ĐÂY LÀ ĐIỂM KHÁC BIỆT ----
        if (isLazy) {
            // == PHIÊN BẢN TỐT: DÙNG LAZYCOLUMN ==
            // Chỉ tạo ra ~10 mục vừa màn hình
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(count = 1_000_000) { index ->
                    MyListItem(index = index + 1, onClick = onItemClick)
                }
            }
        } else {
            // == PHIÊN BẢN LỖI: DÙNG COLUMN ==
            // Cố gắng tạo ra 1.000.000 mục CÙNG LÚC
            // Sẽ bị crash (OutOfMemoryError)
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                (1..1_000_000).forEach { index ->
                    MyListItem(index = index, onClick = onItemClick)
                }
            }
        }
    }
}

/**
 * Một item có thể tái sử dụng cho cả 2 danh sách
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyListItem(index: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "[$index]",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text("The only way to do great work is to love what you do.", modifier = Modifier.weight(1f))
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, "Go")
        }
    }
}