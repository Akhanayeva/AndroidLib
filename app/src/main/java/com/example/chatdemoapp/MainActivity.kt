package com.example.chatdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatlibrary.ChatLibrary
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // без комментария

        setContentView(R.layout.activity_main)

        // Используем findViewById для получения кнопки
        val startChatButton: Button = findViewById(R.id.startChatButton)

        // Кнопка для запуска чата
        startChatButton.setOnClickListener {
            ChatLibrary.start(this)
        }
    }
}
