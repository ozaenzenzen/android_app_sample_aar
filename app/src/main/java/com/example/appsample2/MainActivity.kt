package com.example.appsample2

import android.app.ActionBar.LayoutParams
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appsample1.KonnekNative
import com.example.appsample1.component.MovableFloatingActionButton
import com.example.appsample1.component.MovableFloatingActionButton2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        KonnekNative.initializeSDK(
            this,
            id = "b699182d-5ff0-4161-b649-239234ff9cb9",
            secret = "1dc8e065-2915-4b4e-8df2-45040e8314bd",
            flavorData = "staging",
        )

        val root = findViewById<ViewGroup>(R.id.main)
        val fab3 = KonnekNative.getFloatingButton(this)
        root.addView(fab3)

        println("fab3.layoutParams: ${fab3.layoutParams}")

        // Jika pakai constraint layout
        val layoutParams = fab3.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Extension function to convert dp to px
    private fun Int.dpToPx(): Int =
        (this * resources.displayMetrics.density).toInt()

    fun Int.toPx(context: Context): Int =
        (this * context.resources.displayMetrics.density).toInt()
}