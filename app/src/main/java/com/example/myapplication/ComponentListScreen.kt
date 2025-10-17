package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ComponentListScreen(
    onTextClick: () -> Unit,
    onImageClick: () -> Unit,
    onTextFieldClick: () -> Unit,
    onPasswordFieldClick: () -> Unit,
    onColumnLayoutClick: () -> Unit,
    onRowLayoutClick: () -> Unit,
    onSelfExploreClick: () -> Unit
) {
    // Sử dụng LazyColumn để tối ưu hóa hiệu năng cho danh sách dài
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp) // Khoảng cách tự động giữa các mục
    ) {
        item {
            Text(
                text = "UI Components List",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item { SectionHeader("Display") }
        item {
            ComponentItem(
                title = "Text",
                subtitle = "Displays text",
                onClick = onTextClick
            )
        }
        item {
            ComponentItem(
                title = "Image",
                subtitle = "Displays an image",
                onClick = onImageClick
            )
        }

        item { SectionHeader("Input") }
        item {
            ComponentItem(
                title = "TextField",
                subtitle = "Input field for text",
                onClick = onTextFieldClick
            )
        }
        item {
            ComponentItem(
                title = "PasswordField",
                subtitle = "Input field for passwords",
                onClick = onPasswordFieldClick
            )
        }

        item { SectionHeader("Layout") }
        item {
            ComponentItem(
                title = "Column",
                subtitle = "Arranges elements vertically",
                onClick = onColumnLayoutClick
            )
        }
        item {
            ComponentItem(
                title = "Row",
                subtitle = "Arranges elements horizontally",
                onClick = onRowLayoutClick
            )
        }

        item {
            ComponentItem(
                title = "Tự tìm hiểu",
                subtitle = "Tìm ra tất cả các thành phần UI Cơ bản",
                onClick = onSelfExploreClick,
                backgroundColor = Color(0xFFFAD2D2) // Màu hồng nhạt
            )
        }
    }
}
// Hiển thị tiêu đề
@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentItem(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFD6E4FF) // Màu xanh nhạt mặc định
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentListScreenPreview() {
    MyApplicationTheme {
        ComponentListScreen(
            onTextClick = {},
            onImageClick = {},
            onTextFieldClick = {},
            onPasswordFieldClick = {},
            onColumnLayoutClick = {},
            onRowLayoutClick = {},
            onSelfExploreClick = {}
        )
    }
}