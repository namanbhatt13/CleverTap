package com.example.tap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clevertap.android.sdk.CleverTapAPI
import com.example.tap.databinding.ActivityMainBinding
import com.example.tap.model.EventData

class MainActivity : AppCompatActivity() {

  private lateinit var binding : ActivityMainBinding
  private var cleverTapDefaultInstance: CleverTapAPI? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    //Set Log level to VERBOSE
    CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.VERBOSE)

    cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
    getUserData()

    // on click of button , trigger "Product View" Event
    binding.btnTap.setOnClickListener {
      productViewEvent()
    }
  }

  private fun productViewEvent() {
    val prodViewedAction = mapOf(
      "Product Name" to "CleverTap",
      "Product ID" to 1,
      "Product Image" to "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg",
      "Email" to "namanbhatt121@gmail.com"
    )
    cleverTapDefaultInstance?.pushEvent("Product viewed", prodViewedAction)
  }

  // to simulate User Login
  private fun getUserData(){
    val profileUpdate = HashMap<String, Any>()
    profileUpdate["Name"] = "Naman"
    profileUpdate["Email"] = "namanbhatt121@gmail.com"
    profileUpdate["Phone"] = "+14111111111"
    profileUpdate["Gender"] = "M"
    cleverTapDefaultInstance?.onUserLogin(profileUpdate)

  }
}