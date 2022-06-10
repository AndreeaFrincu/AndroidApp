package com.dev.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /** declare variables */
    private lateinit var myAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        splashImage.startAnimation(topAnimation)
        splashText.startAnimation(bottomAnimation)

        myAuth = FirebaseAuth.getInstance()
        val user = myAuth.currentUser

        /** go to sign in activity if user is not logged in */
        Handler().postDelayed({
            if (user != null) {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
            else {
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
        }, 2000)
    }
}