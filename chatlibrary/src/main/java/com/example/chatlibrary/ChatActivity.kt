package com.example.chatlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatlibrary.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var webSocketClient: WebSocketClient
    private val messages = mutableListOf<String>()
    private lateinit var adapter: ChatAdapter
    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализируем ViewBinding
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupWebSocket()
        setupSendButton()
    }

    private fun setupRecyclerView() {
        adapter = ChatAdapter(messages)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupWebSocket() {
        val listener = ChatWebSocketListener(
            onMessageReceived = { message ->
                runOnUiThread {
                    messages.add("🤖: $message")
                    adapter.notifyDataSetChanged()
                    binding.recyclerView.scrollToPosition(messages.size - 1)
                }
            },
            onConnectionClosed = { /* Игнорируем */ }
        )
        webSocketClient = WebSocketClient(listener)
        webSocketClient.connect()
    }

    private fun setupSendButton() {
        binding.sendButton.setOnClickListener {
            val message = binding.inputEditText.text.toString()
            if (message.isNotEmpty()) {
                messages.add("👤: $message")
                adapter.notifyDataSetChanged()
                webSocketClient.sendMessage(message)
                binding.inputEditText.text.clear()
                binding.recyclerView.scrollToPosition(messages.size - 1)
            }
        }
    }

    override fun onDestroy() {
        webSocketClient.disconnect()
        super.onDestroy()
    }
}
