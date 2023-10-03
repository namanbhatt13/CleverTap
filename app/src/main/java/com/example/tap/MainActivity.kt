package com.example.tap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clevertap.android.sdk.CleverTapAPI
import com.example.tap.databinding.ActivityMainBinding
import com.example.tap.model.EventData

class MainActivity : AppCompatActivity() {

  private lateinit var binding : ActivityMainBinding
  var cleverTapDefaultInstance: CleverTapAPI? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)

    binding.btnTap.setOnClickListener {
      EventData(
        productId = "1",
        productImage = "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg",
        productName = "CleverTap"
      )
    }
  }
}