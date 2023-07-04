package com.github.sookhee.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class DeviceBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_BOOT_COMPLETED -> startService(context!!)
        }
    }

    private fun startService(context: Context) {
        val appIntent = Intent(context, BootService::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(appIntent)
        } else {
            context.startService(appIntent)
        }
    }
}
