package com.example.movies_ch6_binar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

private lateinit var firebaseCrashlytics: FirebaseCrashlytics
private lateinit var firebaseAnalytics: FirebaseAnalytics
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        firebaseAnalytics = Firebase.analytics
        firebaseCrashlytics = Firebase.crashlytics
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}