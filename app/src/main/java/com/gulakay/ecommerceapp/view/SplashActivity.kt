package com.gulakay.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.gulakay.ecommerceapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        Handler().postDelayed({
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}