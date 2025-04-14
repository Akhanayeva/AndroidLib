# 💬 Android Chat Library

A lightweight, plug-and-play Android chat library built with **Kotlin** and **WebSocket**. Easily integrate a modern chat UI in your Android app with just a single method call: `ChatLauncher.start(context)`.

## ✨ Features

- 📲 Modern chat UI with sender/receiver message separation
- 🔗 Built-in WebSocket support (`wss://echo.websocket.org`)
- 🔒 Fully encapsulated — only exposes one public method
- 📦 Easily publishable to GitHub Packages
- ⚠️ Handles special message format `203 = 0xcb`

---

Library url:
https://github.com/Akhanayeva/chatlibrary/packages/2472313

## 🚀 Quick Start

### 1. Add the library to your project

Make sure your `settings.gradle.kts` or `build.gradle.kts` includes GitHub Packages:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/YOUR_GITHUB_USERNAME/YOUR_REPO")
            credentials {
                username = "YOUR_GITHUB_USERNAME"
                password = "YOUR_PERSONAL_ACCESS_TOKEN"
            }
        }
    }
}




https://github.com/user-attachments/assets/ff6878ac-17c6-4e32-9ebd-d18ff51c6276





