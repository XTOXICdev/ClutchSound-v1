package com.example.voicemodeffmedg.model

data class SoundItem(
    val id: String,
    val title: String,
    val category: SoundCategory,
    val durationMs: Long,
    val resName: String,
    val isCustom: Boolean = false,
    val customUri: String? = null,
    val assignedSlot: Int? = null // Slot 1 through 8
)

enum class SoundCategory(val displayName: String, val icon: String) {
    MEMES("Memes", "😂"),
    GAMING("Gaming / FF", "🎯"),
    REACTIONS("Reactions", "🔥"),
    CHANTS("Chants & Beats", "🥁"),
    CUSTOM("Custom Sounds", "📁")
}