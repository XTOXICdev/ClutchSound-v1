package com.example.voicemodeffmedg.audio

import android.content.Context
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Build

data class AudioRoutingState(
    val isHeadsetConnected: Boolean,
    val isBluetoothConnected: Boolean,
    val activeOutputDeviceName: String,
    val micInjectionMode: MicInjectionMode
)

enum class MicInjectionMode {
    INTERNAL_AUDIO_MIX,
    BLUETOOTH_SCO_CHANNEL,
    MEDIA_ROUTED_STREAM,
    EXTERNAL_APP_VIRTUAL_CABLE
}

object AudioRoutingDetector {
    fun detectState(context: Context): AudioRoutingState {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        var hasHeadset = false
        var hasBt = false
        var deviceName = "Built-in Speaker"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
            for (dev in devices) {
                when (dev.type) {
                    AudioDeviceInfo.TYPE_WIRED_HEADSET, AudioDeviceInfo.TYPE_WIRED_HEADPHONES -> {
                        hasHeadset = true
                        deviceName = "Wired Headset (${dev.productName})"
                    }
                    AudioDeviceInfo.TYPE_BLUETOOTH_A2DP, AudioDeviceInfo.TYPE_BLUETOOTH_SCO -> {
                        hasBt = true
                        deviceName = "Bluetooth Device (${dev.productName})"
                    }
                }
            }
        }

        return AudioRoutingState(
            isHeadsetConnected = hasHeadset,
            isBluetoothConnected = hasBt,
            activeOutputDeviceName = deviceName,
            micInjectionMode = if (hasBt) MicInjectionMode.BLUETOOTH_SCO_CHANNEL else MicInjectionMode.INTERNAL_AUDIO_MIX
        )
    }
}