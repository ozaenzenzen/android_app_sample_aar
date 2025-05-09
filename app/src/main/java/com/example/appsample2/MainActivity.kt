package com.example.appsample2

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appsample1.FloatingButtonView
import com.example.appsample1.KonnekNative

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//
        KonnekNative.initializeSDK2(
            this,
            id = "b699182d-5ff0-4161-b649-239234ff9cb9",
            secret = "1dc8e065-2915-4b4e-8df2-45040e8314bd",
            flavorData = "staging",
        )
//        val root = findViewById<ViewGroup>(R.id.main)
//        val floatBtn = KonnekNative.getFloatingButton(this)
//        root.addView(floatBtn)

//         KonnekNative.getFloatingButton().show()

        val root = findViewById<ViewGroup>(R.id.main)
        val floatBtnView = FloatingButtonView(this)
        root.addView(floatBtnView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}