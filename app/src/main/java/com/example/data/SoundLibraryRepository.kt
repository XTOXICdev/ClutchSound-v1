package com.example.voicemodeffmedg.data

import com.example.voicemodeffmedg.model.SoundCategory
import com.example.voicemodeffmedg.model.SoundItem

object SoundLibraryRepository {
    val defaultSounds = listOf(
        SoundItem(
            id = "headshot_kill",
            title = "Headshot Kill",
            category = SoundCategory.GAMING,
            durationMs = 2100,
            resName = "headshot_kill",
            assignedSlot = 1
        ),
        SoundItem(
            id = "hype_airhorn",
            title = "Hype Airhorn",
            category = SoundCategory.GAMING,
            durationMs = 2800,
            resName = "hype_airhorn",
            assignedSlot = 2
        ),
        SoundItem(
            id = "epic_bass_drop",
            title = "Epic Bass Drop",
            category = SoundCategory.GAMING,
            durationMs = 3200,
            resName = "epic_bass_drop",
            assignedSlot = 3
        ),
        SoundItem(
            id = "game_on",
            title = "Game On",
            category = SoundCategory.GAMING,
            durationMs = 2500,
            resName = "game_on",
            assignedSlot = 4
        ),
        SoundItem(
            id = "ram_ram_bhaiyo",
            title = "Ram Ram Bhaiyo",
            category = SoundCategory.CHANTS,
            durationMs = 3000,
            resName = "ram_ram_bhaiyo",
            assignedSlot = 5
        ),
        SoundItem(
            id = "arabic_meme_beat",
            title = "Arabic Meme Beat",
            category = SoundCategory.MEMES,
            durationMs = 4500,
            resName = "arabic_meme_beat",
            assignedSlot = 6
        ),
        SoundItem(
            id = "funny_laugh",
            title = "Funny Laugh",
            category = SoundCategory.MEMES,
            durationMs = 2900,
            resName = "funny_laugh",
            assignedSlot = 7
        ),
        SoundItem(
            id = "victory_anthem",
            title = "Victory Anthem",
            category = SoundCategory.GAMING,
            durationMs = 3800,
            resName = "victory_anthem",
            assignedSlot = 8
        ),
        SoundItem(
            id = "funny_boing",
            title = "Funny Boing",
            category = SoundCategory.MEMES,
            durationMs = 1200,
            resName = "funny_boing"
        ),
        SoundItem(
            id = "level_up",
            title = "Level Up",
            category = SoundCategory.GAMING,
            durationMs = 1900,
            resName = "level_up"
        ),
        SoundItem(
            id = "lobby_rage",
            title = "Lobby Rage",
            category = SoundCategory.REACTIONS,
            durationMs = 3100,
            resName = "lobby_rage"
        ),
        SoundItem(
            id = "nan_khatai",
            title = "Nan Khatai",
            category = SoundCategory.MEMES,
            durationMs = 2700,
            resName = "nan_khatai"
        ),
        SoundItem(
            id = "sad_trombone",
            title = "Sad Trombone",
            category = SoundCategory.REACTIONS,
            durationMs = 3400,
            resName = "sad_trombone"
        ),
        SoundItem(
            id = "sanskrit_chant",
            title = "Sanskrit Chant",
            category = SoundCategory.CHANTS,
            durationMs = 4100,
            resName = "sanskrit_chant"
        ),
        SoundItem(
            id = "tactical_beeps",
            title = "Tactical Beeps",
            category = SoundCategory.GAMING,
            durationMs = 1800,
            resName = "tactical_beeps"
        ),
        SoundItem(
            id = "who_is_there",
            title = "Who Is There",
            category = SoundCategory.REACTIONS,
            durationMs = 2200,
            resName = "who_is_there"
        )
    )
}