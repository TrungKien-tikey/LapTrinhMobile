package com.example.myapplication

import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenScaffold(
    title: String,
    onBackClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Composable
fun TextDetailScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(title = "Text Detail", onBackClick = onBackClick) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()//chiếm toàn bộ không gian màn hình
                .padding(paddingValues) // Áp dụng padding của Scaffold
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Nội dung gốc
            Text(
                text = buildAnnotatedString {
                    append("The ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append("quick")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF8B4513)
                        )
                    ) {
                        append("Brown")
                    }
                    append(" fox jumps ")
                    withStyle(
                        style = SpanStyle(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("over")
                    }
                    append(" ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("the")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = FontFamily.Cursive,
                            fontStyle = FontStyle.Italic
                        )
                    ) {
                        append("lazy")
                    }
                    append(" dog.")
                },
                fontSize = 28.sp
            )
        }
    }
}

@Composable
fun ImageDetailScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(title = "Image Detail", onBackClick = onBackClick) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nội dung gốc
            Text("Ảnh từ Internet (URL)", fontWeight = FontWeight.Bold)
            AsyncImage(
                model = "https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/hoc_phi_uth_2025_c5fa7e3508.jpg",
                contentDescription = "Ảnh FPT University",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text("Ảnh từ trong app (Drawable)", fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.uth),
                contentDescription = "Ảnh UTH",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TextFieldDetailScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(title = "TextField Detail", onBackClick = onBackClick) { paddingValues ->
        var textValue by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nội dung gốc
            OutlinedTextField(
                value = textValue,
                onValueChange = { newValue -> textValue = newValue },
                label = { Text("Thông tin nhập") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Tự động cập nhật:")
            Text(textValue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}

@Composable
fun PasswordFieldDetailScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(
        title = "Password Field Detail",
        onBackClick = onBackClick
    ) { paddingValues ->
        var passwordVisible by remember { mutableStateOf(false) }//biến trạng thái thứ hai để kiểm soát việc mật khẩu đang được ẩn hay hiện
        var password by remember { mutableStateOf("") }//  biến trạng thái để lưu trữ nội dung
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nội dung gốc
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
                }
            )
        }
    }
}

@Composable
fun RowLayoutScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(title = "Row Layout Detail", onBackClick = onBackClick) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Nội dung gốc
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.LightGray)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.LightGray)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}

@Composable
fun ColumnLayoutDetailScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(
        title = "Column Layout Detail",
        onBackClick = onBackClick
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Nội dung gốc
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Cyan)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            )
        }
    }
}

@Composable
fun SelfExploreScreen(onBackClick: () -> Unit) {
    DetailScreenScaffold(title = "Self Explore", onBackClick = onBackClick) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Nội dung gốc
            Text(
                text = "Hãy tự khám phá và thêm các Composable khác vào đây nhé!",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true, name = "Text Detail Screen")
@Composable
fun TextDetailScreenPreview() {
    MyApplicationTheme {
        // Cung cấp một hành động rỗng để preview
        TextDetailScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Image Detail Screen")
@Composable
fun ImageDetailScreenPreview() {
    MyApplicationTheme {
        ImageDetailScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Text Field Detail")
@Composable
fun TextFieldDetailScreenPreview() {
    MyApplicationTheme {
        TextFieldDetailScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Password Field Detail")
@Composable
fun PasswordFieldDetailScreenPreview() {
    MyApplicationTheme {
        PasswordFieldDetailScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Column Layout Detail")
@Composable
fun ColumnLayoutDetailScreenPreview() {
    MyApplicationTheme {
        ColumnLayoutDetailScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Row Layout Screen")
@Composable
fun RowLayoutScreenPreview() {
    MyApplicationTheme {
        RowLayoutScreen(onBackClick = {})
    }
}

@Preview(showBackground = true, name = "Self Explore Screen")
@Composable
fun SelfExploreScreenPreview() {
    MyApplicationTheme {
        SelfExploreScreen(onBackClick = {})
    }
}