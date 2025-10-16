package com.example.myapplication // Thay bằng package của bạn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ProfileScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent là hàm chính để bắt đầu xây dựng giao diện bằng Compose
        setContent {
            // MyApplicationTheme là theme mặc định của dự án, bạn có thể tùy chỉnh nó
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Gọi hàm Composable chính để hiển thị giao diện
                    ComposeTutorialScreen()
                }
            }
        }
    }
}

// Annotation @Composable đánh dấu đây là một hàm xây dựng giao diện
@Composable
fun ComposeTutorialScreen() {
    // Column dùng để sắp xếp các thành phần con theo chiều dọc
    Column(
        // modifier dùng để tùy chỉnh giao diện và hành vi của một Composable
        modifier = Modifier
            .fillMaxSize() // Lấp đầy toàn bộ không gian màn hình
            .padding(32.dp), // Thêm khoảng đệm 32dp ở các cạnh
        verticalArrangement = Arrangement.Center, // Căn giữa các thành phần con theo chiều dọc
        horizontalAlignment = Alignment.CenterHorizontally // Căn giữa các thành phần con theo chiều ngang
    ) {
        // Image dùng để hiển thị hình ảnh
        // Lưu ý: bạn cần thêm file ảnh logo vào thư mục res/drawable
        // Tôi sẽ dùng một icon mặc định để thay thế ở đây.
        // Hãy thay thế R.drawable.ic_launcher_foreground bằng file logo của bạn.
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(120.dp) // Đặt kích thước cho logo
        )

        // Spacer tạo một khoảng trống giữa các thành phần
        Spacer(modifier = Modifier.height(24.dp))

        // Text dùng để hiển thị văn bản
        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp, // Kích thước chữ
            fontWeight = FontWeight.Bold // In đậm
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development on Android.",
            textAlign = TextAlign.Center, // Căn giữa nội dung văn bản
            style = MaterialTheme.typography.bodyLarge
        )

        // Spacer này tạo khoảng trống lớn để đẩy nút xuống dưới
        Spacer(modifier = Modifier.height(48.dp))

        // Button tạo ra một nút bấm
        Button(
            onClick = { /* TODO: Xử lý sự kiện khi nút được nhấn */ },
            modifier = Modifier
                .fillMaxWidth() // Chiếm toàn bộ chiều rộng
                .height(50.dp), // Đặt chiều cao
            shape = RoundedCornerShape(16.dp), // Bo góc cho nút
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF)) // Đặt màu nền
        ) {
            Text(
                text = "Get started",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

// @Preview cho phép bạn xem trước giao diện ngay trong Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ComposeTutorialScreen()
    }
}
