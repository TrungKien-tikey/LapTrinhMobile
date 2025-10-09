package com.example.myapplication // Thay bằng package của bạn

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThucHanhEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thuc_hanh_email)

        // 1. Ánh xạ các view từ XML
        val etEmail = findViewById<EditText>(R.id.et_email)
        val btnCheck = findViewById<Button>(R.id.btn_check_email)
        val tvResult = findViewById<TextView>(R.id.tv_email_result)

        // 2. Gán sự kiện click cho button
        btnCheck.setOnClickListener {
            // Lấy text từ EditText và xóa khoảng trắng thừa
            val email = etEmail.text.toString().trim()

            // 3. Thực hiện kiểm tra theo logic
            if (email.isNullOrEmpty()) {
                // Nếu email rỗng hoặc null
                tvResult.text = "Email không hợp lệ"
                tvResult.setTextColor(Color.RED)
            } else if (!email.contains("@")) {
                // Nếu email không chứa ký tự @
                tvResult.text = "Email không đúng định dạng"
                tvResult.setTextColor(Color.RED)
            } else {
                // Nếu email hợp lệ
                tvResult.text = "Bạn đã nhập email hợp lệ"
                tvResult.setTextColor(Color.GREEN) // Màu xanh cho thành công
            }
        }
    }
}