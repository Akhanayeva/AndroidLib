// chatlibrary/src/main/java/com/example/chatlibrary/ChatWebSocketListener.kt
package com.example.chatlibrary

import okhttp3.*

class ChatWebSocketListener(
    private val onMessageReceived: (String) -> Unit,
    private val onConnectionClosed: () -> Unit
) : WebSocketListener() {

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        if (text == "203 = 0xcb") {
            onMessageReceived("🔮 Сервер прислал секретный код!")
        } else {
            onMessageReceived(text)
        }
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        onConnectionClosed()
    }
}