package com.example.myapplication // Thay thế bằng tên package của bạn

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
class ThucHanh2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dòng này nạp giao diện từ file activity_thuc_hanh2.xml
        setContentView(R.layout.activity_thuc_hanh2)

        // 1. Ánh xạ (liên kết) các view từ file XML vào biến trong code Kotlin
        val etQuantity = findViewById<EditText>(R.id.et_quantity)
        val btnCreate = findViewById<Button>(R.id.btn_create)
        val tvErrorMessage = findViewById<TextView>(R.id.tv_error_message)
        val listContainer = findViewById<LinearLayout>(R.id.list_container)

        // 2. Thiết lập sự kiện lắng nghe khi người dùng nhấn vào nút "Tạo"
        btnCreate.setOnClickListener {
            // Mỗi lần nhấn nút, xóa hết danh sách cũ và ẩn thông báo lỗi đi
            listContainer.removeAllViews()
            tvErrorMessage.visibility = View.GONE

            // Lấy chuỗi ký tự người dùng đã nhập
            val inputText = etQuantity.text.toString()

            // 3. Kiểm tra tính hợp lệ của dữ liệu nhập vào
            try {
                // Thử chuyển đổi chuỗi sang dạng số nguyên
                val quantity = inputText.toInt()

                // Nếu là số, tiếp tục kiểm tra xem số đó có lớn hơn 0 không
                if (quantity > 0) {
                    // Nếu hợp lệ (số nguyên dương), gọi hàm để tạo danh sách button
                    generateButtonList(quantity, listContainer)
                } else {
                    // Nếu là số 0 hoặc số âm, hiển thị thông báo lỗi
                    tvErrorMessage.visibility = View.VISIBLE
                }
            } catch (e: NumberFormatException) {
                // Nếu không thể chuyển đổi sang số (ví dụ: người dùng nhập "abc" hoặc để trống),
                // chương trình sẽ nhảy vào đây và hiển thị thông báo lỗi.
                tvErrorMessage.visibility = View.VISIBLE
            }
        }
    }

    /**
     * Hàm này có nhiệm vụ tạo ra một danh sách các nút bấm
     * và thêm chúng vào một layout container cho trước.
     */
    private fun generateButtonList(count: Int, container: LinearLayout) {
        for (i in 1..count) {
            val button = Button(this)

            // --- CÁC THAY ĐỔI NẰM Ở ĐÂY ---

            // 1. Chỉ hiển thị số, không hiển thị chữ "Button"
            button.text = "$i"

            // 2. Đặt màu chữ là màu trắng để nổi bật trên nền đỏ
            button.setTextColor(Color.WHITE)

            // 3. Áp dụng file drawable custom_red_button.xml làm nền
            button.setBackgroundResource(R.drawable.custom_red_button)

            // --- HẾT PHẦN THAY ĐỔI ---

            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 8, 0, 8)
            button.layoutParams = layoutParams

            container.addView(button)
        }
    }
}