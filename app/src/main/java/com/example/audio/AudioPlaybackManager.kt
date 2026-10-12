package com.example.voicemodeffmedg.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.Log

object AudioPlaybackManager {
    private var mediaPlayer: MediaPlayer? = null
    var isPlaying = false
        private set
    var currentSoundId: String? = null
        private set
    var volume: Float = 1.0f

    fun playRawSound(context: Context, soundResId: Int, soundId: String, onCompletion: () -> Unit = {}) {
        stop()
        try {
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .build()
                )
                val afd = context.resources.openRawResourceFd(soundResId)
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                afd.close()
                setVolume(volume, volume)
                prepare()
                start()
                setOnCompletionListener {
                    isPlaying = false
                    currentSoundId = null
                    onCompletion()
                }
            }
            isPlaying = true
            currentSoundId = soundId
        } catch (e: Exception) {
            Log.e("AudioPlaybackManager", "Error playing sound: ${e.message}")
            isPlaying = false
        }
    }

    fun stop() {
        try {
            mediaPlayer?.apply {
                if (isPlaying) stop()
                release()
            }
        } catch (e: Exception) {
            Log.e("AudioPlaybackManager", "Error stopping: ${e.message}")
        } finally {
            mediaPlayer = null
            isPlaying = false
            currentSoundId = null
        }
    }
}