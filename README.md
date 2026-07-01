# QuickDrop (NearShare)

QuickDrop is a cross-platform file sharing application designed for seamless transfer between Android and Desktop devices. It focuses on speed, simplicity, and a modern user interface.

## 🚀 Features

- **Cross-Platform Support**: Seamlessly share files between Android devices and Desktop (JVM).
- **Network Discovery**: Automatically finds devices on the same local network for quick pairing.
- **Fast Transfers**: Optimized for high-speed file sharing over local Wi-Fi.
- **Modern UI**: Built with Jetpack Compose for Android and Compose Multiplatform for Desktop.
- **Hilt Dependency Injection**: robust architecture using Hilt for dependency management.

## 🏗 Architecture

The project follows a modular, clean architecture approach:

- **`:app`**: The main Android application module.
- **`:desktopApp`**: The JVM-based desktop application.
- **`:feature:*`**: Feature-specific modules (Discovery, Transfer, Home, Settings, etc.).
- **`:core:common`**: Shared utilities, dispatchers, and common base classes.
- **`:core:network`**: Networking logic for device discovery and file transfer.
- **`:core:database`**: Local persistence using Room (Android) and specialized desktop solutions.
- **`:core:ui` / `:core:designsystem`**: Shared UI components and theme definitions.

## 🛠 Tech Stack

- **Kotlin**: 100% Kotlin codebase.
- **Jetpack Compose**: Modern toolkit for building native UI.
- **Hilt/Dagger**: Dependency injection for Android.
- **Coroutines & Flow**: Asynchronous programming and reactive data streams.
- **KSP**: Kotlin Symbol Processing for efficient code generation.
- **Ktor**: Used for high-performance networking and server implementation.

## 🔧 Setup & Build

### Prerequisites
- Android Studio Iguana or newer.
- JDK 17+.

### Building
To build the Android application:
```bash
./gradlew :app:assembleDebug
```

To run the Desktop application:
```bash
./gradlew :desktopApp:run
```

## 📝 Recent Updates
- Fixed a `Dagger/MissingBinding` error for `@IoDispatcher` by properly configuring Hilt processing in the `:core:common` module.
- Initialized Git repository and pushed to GitHub.

---
Developed by [vikasdev9](https://github.com/vikasdev9)
