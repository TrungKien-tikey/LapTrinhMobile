package com.example.myapplication // Giữ nguyên tên package của bạn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dòng này sẽ tìm và nạp giao diện từ file activity_main.xml
        setContentView(R.layout.activity_main)
    }
}