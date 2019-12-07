package com.example.leaguestatus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.leaguestatus.dependencies.applicationModules
import com.example.leaguestatus.presentation.accounts.view.AccountsActivity
import org.koin.android.ext.android.startKoin

class SplashScreenActivity : AppCompatActivity() {

    private val delay: Long = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startKoin(this, applicationModules)
        Handler().postDelayed({
            startActivity(Intent(this, AccountsActivity::class.java))
            finish()
        }, delay)
    }
}
