package com.example.movies_ch6_binar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies_ch6_binar.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}