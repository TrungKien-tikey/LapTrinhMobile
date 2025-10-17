
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun WelcomeScreen(onReadyClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),//chiếm toàn bộ không gian màn hình
        verticalArrangement = Arrangement.Center,//Căn giữa tất cả các phần tử con theo chiều dọc
        horizontalAlignment = Alignment.CenterHorizontally// Căn giữa tất cả các phần tử con theo chiều ngang.
    ) {

        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_logo),// tải ảnh
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(120.dp) // Đặt kích thước cho ảnh
        )

        Spacer(modifier = Modifier.height(24.dp)) // Tạo khoảng cách

        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "UI components demo")
        Spacer(modifier = Modifier.height(32.dp))


        Button(onClick = onReadyClick) {
            Text("I'm ready")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    MyApplicationTheme {
        WelcomeScreen(onReadyClick = {})
    }
}