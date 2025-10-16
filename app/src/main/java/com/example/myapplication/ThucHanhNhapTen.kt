package com.example.myapplication // Thay bằng package của bạn

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThucHanhNhapTen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Kết nối bộ não này với thân thể (giao diện XML)
        setContentView(R.layout.activity_thuc_hanh_nhap_ten)

        // 1. Bộ não "nhận biết" các bộ phận trên cơ thể (ánh xạ)
        val etTen = findViewById<EditText>(R.id.et_ten)
        val btnSayHi = findViewById<Button>(R.id.btn_check)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        // 2. Bộ não ra lệnh: "Khi nút 'Say Hi' được nhấn..."
        btnSayHi.setOnClickListener {
            // "...hãy lấy thông tin từ ô nhập liệu..."
            val tenNguoiDung = etTen.text.toString().trim()

            // "...suy nghĩ và quyết định..."
            if (tenNguoiDung.isNotEmpty()) {
                // "...nếu có tên, hãy hiển thị lời chào."
                tvResult.text = "Chào bạn, $tenNguoiDung!"
            } else {
                // "...nếu không có tên, hãy yêu cầu nhập."
                tvResult.text = "Vui lòng nhập tên của bạn"
            }

            // "...cuối cùng, đổi màu chữ kết quả thành màu đỏ."
            tvResult.setTextColor(Color.RED)
        }
    }
}

