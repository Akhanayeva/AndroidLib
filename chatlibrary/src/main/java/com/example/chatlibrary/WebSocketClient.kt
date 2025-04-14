// chatlibrary/src/main/java/com/example/chatlibrary/WebSocketClient.kt
package com.example.chatlibrary

import okhttp3.*

class WebSocketClient(private val listener: WebSocketListener) {
    private val client = OkHttpClient()
    private var webSocket: WebSocket? = null

    fun connect() {
        val request = Request.Builder()
            .url("wss://echo.websocket.org/")
            .build()
        webSocket = client.newWebSocket(request, listener)
    }

    fun sendMessage(message: String) {
        webSocket?.send(message)
    }

    fun disconnect() {
        webSocket?.close(1000, "Closing connection")
        client.dispatcher.executorService.shutdown()
    }
}