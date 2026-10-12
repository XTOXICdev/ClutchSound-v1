package com.example.voicemodeffmedg

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.voicemodeffmedg.service.FloatingSoundboardService
import com.example.voicemodeffmedg.ui.FFMedViewModel
import com.example.voicemodeffmedg.ui.screens.*
import com.example.voicemodeffmedg.ui.theme.VoiceModeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: FFMedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VoiceModeTheme {
                var selectedTab by remember { mutableStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                NavigationBarItem(
                                    selected = selectedTab == 0,
                                    onClick = { selectedTab = 0 },
                                    label = { Text("Quick Slots") },
                                    icon = { Text("⚡") }
                                )
                                NavigationBarItem(
                                    selected = selectedTab == 1,
                                    onClick = { selectedTab = 1 },
                                    label = { Text("Library") },
                                    icon = { Text("🎵") }
                                )
                                NavigationBarItem(
                                    selected = selectedTab == 2,
                                    onClick = { selectedTab = 2 },
                                    label = { Text("Audio Route") },
                                    icon = { Text("🎧") }
                                )
                                NavigationBarItem(
                                    selected = selectedTab == 3,
                                    onClick = { selectedTab = 3 },
                                    label = { Text("Settings") },
                                    icon = { Text("⚙️") }
                                )
                            }
                        }
                    ) { padding ->
                        Box(modifier = Modifier.padding(padding)) {
                            when (selectedTab) {
                                0 -> QuickSlotsScreen(
                                    viewModel = viewModel,
                                    onLaunchFloatingOverlay = { checkOverlayPermissionAndStart() }
                                )
                                1 -> SoundLibraryScreen(viewModel = viewModel)
                                2 -> AudioRoutingGuideScreen(viewModel = viewModel)
                                3 -> SettingsScreen(viewModel = viewModel)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun checkOverlayPermissionAndStart() {
        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivity(intent)
            Toast.makeText(
                this,
                "Please enable 'Allow display over other apps' to use floating soundboard in Free Fire",
                Toast.LENGTH_LONG
            ).show()
        } else {
            val serviceIntent = Intent(this, FloatingSoundboardService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
            Toast.makeText(this, "Floating Soundboard Started!", Toast.LENGTH_SHORT).show()
        }
    }
}