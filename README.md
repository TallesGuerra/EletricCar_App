# ⚡ Electric Car App

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5+-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material3](https://img.shields.io/badge/Material%203-Design-6200EE?style=for-the-badge)

**Android app for browsing and exploring electric vehicles, developed during the Cognizant Mobile Developer Bootcamp.**

---

## 📱 Features

- ✅ Browse a curated list of electric vehicles
- ✅ View detailed specs for each car (range, power, charging time)
- ✅ Clean and modern UI with Material Design 3
- ✅ Smooth navigation between list and detail screens
- ✅ Light and dark theme support
- ✅ Responsive layout for different screen sizes

---

## 🏗️ Architecture

```
com.example.eletriccarapp/
│
├── 📱 MainActivity.kt                  # Main entry point
│
├── 🧩 ui/                              # UI layer
│   ├── CarListScreen.kt               # Vehicle listing screen
│   └── CarDetailScreen.kt             # Vehicle detail screen
│
├── 📊 model/                           # Data models
│   └── ElectricCar.kt                 # Vehicle data class
│
├── 🗃️ data/                            # Data layer
│   └── CarRepository.kt               # Data source and repository
│
└── 🎨 ui/theme/                        # Material 3 theme
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

### Design Principles Applied

- **Separation of Concerns** — UI, data, and logic layers are decoupled
- **Single Responsibility** — each component has one clear purpose
- **Clean Code** — readable and self-documented code
- **Reusable Components** — composables designed for reuse

---

## 🔧 Technologies

| Technology          | Version | Description                         |
|---------------------|---------|-------------------------------------|
| **Kotlin**          | 1.9+    | Modern, concise Android language    |
| **Jetpack Compose** | 1.5+    | Declarative and reactive UI toolkit |
| **Material 3**      | Latest  | Google's design system              |
| **Android SDK**     | 24+     | Compatible with 95%+ of devices     |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or higher
- JDK 17+
- Android SDK 34
- Physical device or emulator with API 24+

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/TallesGuerra/EletricCar_App.git
   cd EletricCar_App
   ```

2. **Open in Android Studio**
   - File → Open → Select the project folder

3. **Sync dependencies**
   - Gradle will sync automatically

4. **Run the app**
   - Click **Run** ▶️ or press `Shift + F10`
   - Select a device or emulator

---

## 💡 Concepts Demonstrated

- Jetpack Compose layouts and navigation
- `remember` and `mutableStateOf` for reactive state
- `LazyColumn` for efficient list rendering
- Material Design 3 components and theming
- Multi-screen navigation with Compose Navigation
- Data modeling with Kotlin data classes
- Modular and reusable component architecture

---

## 🎓 Context

This project was developed as part of the **Cognizant Mobile Developer Bootcamp** in partnership with **DIO (Digital Innovation One)**. It served as a practical exercise to consolidate Android development skills using modern Kotlin and Jetpack Compose.

---

## 🔄 Roadmap

- [x] Electric vehicle listing
- [x] Vehicle detail screen
- [x] Material Design 3 UI
- [ ] Remote data fetching with Retrofit
- [ ] Local persistence with Room Database
- [ ] MVVM architecture with ViewModel + StateFlow

---

## 👨‍💻 Author

- 📧 [talles-guerra@hotmail.com](mailto:talles-guerra@hotmail.com)
- 💼 [LinkedIn](https://www.linkedin.com/in/talles-guerra/)
- 🐙 [GitHub](https://github.com/TallesGuerra)

---

**Made with ❤️ and Kotlin**
