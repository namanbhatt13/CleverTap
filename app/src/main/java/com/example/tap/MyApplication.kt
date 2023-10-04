package com.example.tap

import android.app.Application
import android.app.NotificationManager
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI

class MyApplication : Application() {

  override fun onCreate() {
    CleverTapAPI.changeCredentials("884-5K7-RK6Z", "a35-4bb")
    ActivityLifecycleCallback.register(this) // Must be called before super.onCreate()
    super.onCreate()

    CleverTapAPI.createNotificationChannel(
      this, "Test", "Test",
      "Notifications", NotificationManager.IMPORTANCE_MAX, true
    )
  }
}