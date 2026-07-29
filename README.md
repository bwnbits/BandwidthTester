# 🚀 Bandwidth Tester

<p align="center">

<img src="https://img.shields.io/badge/Platform-Android-green?style=for-the-badge">
<img src="https://img.shields.io/badge/Language-Kotlin-purple?style=for-the-badge">
<img src="https://img.shields.io/badge/UI-Jetpack%20Compose-blue?style=for-the-badge">
<img src="https://img.shields.io/badge/Architecture-MVVM-orange?style=for-the-badge">

</p>

A native Android application built with **Kotlin** that continuously downloads internet data and measures real-time network performance.

The app works similarly to a speed test tool but focuses on continuous bandwidth consumption, live statistics, and background operation.

---

# 📱 Features

## 🌐 Continuous Download Engine

- Unlimited downloading
- Data streamed directly from the internet
- Downloaded bytes are counted and discarded
- No files are saved to device storage
- Automatic retry on network failures

---

## 📊 Live Statistics

The application displays:

- Current download speed
- Average download speed
- Total data consumed
- MB / GB tracking
- Running duration
- Remaining time
- Download status

---

## ⏱ Duration Controls

Available test durations:

- 5 minutes
- 10 minutes
- 30 minutes
- 1 hour
- 2 hours
- Unlimited mode

---

## 🔋 Background Support

The application uses Android Foreground Service:

- Continues downloading when app is minimized
- Persistent notification
- Live speed updates
- Download statistics in notification

---

# 🛠 Tech Stack

## Android

- Kotlin
- Android SDK 26+
- Android Studio
- Jetpack Compose
- Material 3

## Architecture

- MVVM
- Kotlin Coroutines
- StateFlow

## Networking

- OkHttp
- Streaming HTTP requests
- Buffered downloading

---

# 🏗 Project Structure
BandwidthTester
│
├── MainActivity.kt
│
├── BandwidthViewModel.kt
│
├── Downloader.kt
│
├── DownloadService.kt
│
├── NotificationHelper.kt
│
├── model
│ └── DownloadStats.kt
│
└── ui
├── BandwidthScreen.kt
└── theme

---

# 📸 Screenshots

Coming soon.

---

# 📦 Installation

## Download APK

Go to:

GitHub Releases → Latest Release

Download:
BandwidthTester.apk

Install on Android 8.0+

---

# ⚙ Requirements

- Android 8.0 or higher
- Active internet connection
- Network permission enabled

---

# 🔐 Permissions Used

Required for download notifications.

---

# 🚧 Development Status

Current Version:
v1.0.0

Completed:

✅ Kotlin Android project  
✅ Material 3 UI  
✅ MVVM structure  
✅ Foreground service setup  
✅ APK build system  
✅ GitHub publishing  

Future improvements:

- Better speed graph
- Server selection
- Network history
- Dark mode improvements
- Advanced analytics

---

# 👨‍💻 Author

**bwnbits**

GitHub:

https://github.com/bwnbits

---

# ⚠️ Disclaimer

This application intentionally consumes internet bandwidth.

Use responsibly and monitor your data plan usage.

The developer is not responsible for excessive data consumption.
