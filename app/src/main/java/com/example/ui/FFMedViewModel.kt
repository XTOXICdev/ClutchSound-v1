package com.example.voicemodeffmedg.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.voicemodeffmedg.data.SoundLibraryRepository
import com.example.voicemodeffmedg.model.SoundCategory
import com.example.voicemodeffmedg.model.SoundItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FFMedViewModel(application: Application) : AndroidViewModel(application) {
    private val _soundList = MutableStateFlow<List<SoundItem>>(SoundLibraryRepository.defaultSounds)
    val soundList: StateFlow<List<SoundItem>> = _soundList.asStateFlow()

    private val _activeSlot = MutableStateFlow<Int?>(null)
    val activeSlot: StateFlow<Int?> = _activeSlot.asStateFlow()

    private val _masterVolume = MutableStateFlow(1.0f)
    val masterVolume: StateFlow<Float> = _masterVolume.asStateFlow()

    private val _isOverlayActive = MutableStateFlow(false)
    val isOverlayActive: StateFlow<Boolean> = _isOverlayActive.asStateFlow()

    fun assignSoundToSlot(soundId: String, slotNumber: Int) {
        _soundList.value = _soundList.value.map { item ->
            when {
                item.id == soundId -> item.copy(assignedSlot = slotNumber)
                item.assignedSlot == slotNumber -> item.copy(assignedSlot = null)
                else -> item
            }
        }
    }

    fun setVolume(vol: Float) {
        _masterVolume.value = vol
    }
}