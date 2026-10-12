package com.example.voicemodeffmedg.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import com.example.voicemodeffmedg.audio.AudioPlaybackManager
import com.example.voicemodeffmedg.data.SoundLibraryRepository

class FloatingSoundboardService : Service() {

    private var windowManager: WindowManager? = null
    private var floatingView: View? = null
    private var isExpanded = false

    override fun onCreate() {
        super.onCreate()
        startForegroundNotification()
        setupFloatingWidget()
    }

    private fun startForegroundNotification() {
        val channelId = "floating_soundboard_channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Voice Mode Floating Overlay",
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }

        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
                .setContentTitle("VOICE MODE FFMEDG Active")
                .setContentText("Floating overlay is ready for Free Fire gaming")
                .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                .build()
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(this)
                .setContentTitle("VOICE MODE FFMEDG Active")
                .setContentText("Floating overlay is ready")
                .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                .build()
        }

        startForeground(1001, notification)
    }

    private fun setupFloatingWidget() {
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val layoutFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            @Suppress("DEPRECATION")
            WindowManager.LayoutParams.TYPE_PHONE
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            layoutFlag,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = 50
            y = 200
        }

        // Implementation attaches draggable touch listener to update params.x & params.y
    }

    override fun onDestroy() {
        super.onDestroy()
        floatingView?.let { windowManager?.removeView(it) }
        AudioPlaybackManager.stop()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}