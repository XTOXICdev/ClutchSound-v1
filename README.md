# VOICE MODE FFMEDG 🎮🔊

**Floating Gaming Soundboard & Voice Overlay for Free Fire and Battle Royale Games**

VOICE MODE FFMEDG is an Android utility built with Kotlin and Jetpack Compose that provides a floating soundboard overlay for gamers. Trigger meme sounds, tactical callouts, and audio clips directly over games like Free Fire, PUBG, and BGMI without switching apps.

---

## ⚡ Features
- 🎈 **Floating Overlay Window**: Draggable floating widget that sits on top of games.
- ⚡ **Quick Slots (8 Slots)**: Instant trigger buttons for your most-used sounds.
- 🔊 **16 High-Quality Built-In Sounds**:
  - Arabic Meme Beat
  - Epic Bass Drop
  - Funny Boing
  - Funny Laugh
  - Game On
  - Headshot Kill
  - Hype Airhorn
  - Level Up
  - Lobby Rage
  - Nan Khatai
  - Ram Ram Bhaiyo
  - Sad Trombone
  - Sanskrit Chant
  - Tactical Beeps
  - Victory Anthem
  - Who Is There
- 🎚️ **Audio Routing & Mic Injection**: Playback manager with AudioFocus, speaker/headset routing, and mic stream routing.
- 🎨 **Modern Dark UI**: Jetpack Compose material theme with FF gaming accent colors (Orange, Neon Cyan, and Slate Dark).
- ⚙️ **Custom Slot Assignment & Renaming**: Personalize sound triggers.

---

## 🚀 Setup & Build

### Prerequisites
- Android Studio Ladybug or newer
- JDK 17 or JDK 21
- Android SDK 34+ (compileSdk 34, minSdk 24)

### Clone & Build
```bash
git clone https://github.com/<your-username>/VOICE-MODE-FFMEDG.git
cd VOICE-MODE-FFMEDG
./gradlew assembleDebug
```

The generated APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

---

## 📱 Permissions Required
- `SYSTEM_ALERT_WINDOW`: Allows drawing the floating soundboard overlay on top of other games.
- `RECORD_AUDIO`: Required for mic monitoring and audio routing.
- `MODIFY_AUDIO_SETTINGS`: Enables audio channel and routing control.
- `FOREGROUND_SERVICE`: Keeps floating service active while gaming.
