package com.github.sookhee.broadcasttest

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val permissionResultLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result == true) {
                Toast.makeText(this@MainActivity, "알림 허용함", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "알림 허용x, 서비스 사용x", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // notification 등록을 위한 퍼미션 받기
        val checkResult = ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS)
        if (checkResult == PackageManager.PERMISSION_DENIED) {
            permissionResultLauncher.launch(POST_NOTIFICATIONS)
        } else {
            Toast.makeText(this@MainActivity, "알림 허용함", Toast.LENGTH_SHORT).show()
        }
    }
}