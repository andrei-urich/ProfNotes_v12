package ru.profsoft.profnotes_v1.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import ru.profsoft.profnotes_v1.MainActivity
import ru.profsoft.profnotes_v1.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

         */

        setContentView(R.layout.activity_splash_screen)
        val ivSplash = findViewById<ImageView>(R.id.iv_splash)
        ivSplash.alpha = 0f
        ivSplash.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}