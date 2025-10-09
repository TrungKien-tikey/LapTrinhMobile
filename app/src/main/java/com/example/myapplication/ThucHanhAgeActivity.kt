package com.example.myapplication // Thay bằng package của bạn

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThucHanhAgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thuc_hanh_age)

        val etName = findViewById<EditText>(R.id.et_name)
        val etAge = findViewById<EditText>(R.id.et_age)
        val btnCheck = findViewById<Button>(R.id.btn_check_age)
        val tvResult = findViewById<TextView>(R.id.tv_age_result)

        btnCheck.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageString = etAge.text.toString().trim()

            // Kiểm tra xem có bỏ trống trường nào không
            if (name.isEmpty() || ageString.isEmpty()) {
                tvResult.text = "Vui lòng nhập đủ tên và tuổi"
                tvResult.setTextColor(Color.RED)
                return@setOnClickListener
            }

            try {
                val age = ageString.toInt()
                val category: String

                // Phân loại độ tuổi
                when {
                    age <= 0 -> {
                        category = "Tuổi không hợp lệ"
                    }
                    age < 2 -> {
                        category = "Em bé"
                    }
                    age < 7 -> {
                        category = "Trẻ em"
                    }
                    age <= 65 -> {
                        category = "Người lớn"
                    }
                    else -> {
                        category = "Người già"
                    }
                }

                // Hiển thị kết quả
                if (category == "Tuổi không hợp lệ") {
                    tvResult.text = category
                    tvResult.setTextColor(Color.RED)
                } else {
                    tvResult.text = "$name là $category"
                    tvResult.setTextColor(Color.BLUE)
                }

            } catch (e: NumberFormatException) {
                // Xử lý nếu người dùng nhập chữ vào ô tuổi
                tvResult.text = "Tuổi phải là một con số"
                tvResult.setTextColor(Color.RED)
            }
        }
    }
}