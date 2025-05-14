package com.example.appsample2

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appsample1.FloatingButtonView
import com.example.appsample1.KonnekNative
import com.example.appsample1.component.MovableFloatingActionButton
import com.example.appsample1.component.MovableFloatingActionButton2

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

//        val fab = MovableFloatingActionButton(this).apply {
//            // Customize the FAB if needed
//            setImageResource(android.R.drawable.ic_input_add) // Example icon
//            layoutParams = CoordinatorLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            ).apply {
//                gravity = Gravity.BOTTOM or Gravity.END
//                marginEnd = 32.dpToPx()
//                bottomMargin = 32.dpToPx()
//            }
//        }
//        val fab = KonnekNative.getFloatingButton(context = this)
//
//        // Add to root layout
//        root.addView(fab)

        val fab2 = KonnekNative.getFloatingButton2(this)
//        val fab2 = MovableFloatingActionButton2(this).apply {
////            setCompoundDrawablesWithIntrinsicBounds(
////                ContextCompat.getDrawable(context, com.example.appsample1.R.drawable.ic_konnek), // left
////                null, // top
////                null, // right
////                null  // bottom
////            )
////            background = ContextCompat.getDrawable(context, com.example.appsample1.R.drawable.ic_konnek)
//            setImageResource(com.example.appsample1.R.drawable.ic_konnek)
//            scaleType = ImageView.ScaleType.FIT_CENTER // or CENTER_CROP, CENTER_INSIDE
//            setBackgroundColor(Color.WHITE)
//            setPadding(20, 20, 20, 20)
//            layoutParams = CoordinatorLayout.LayoutParams(
////                ViewGroup.LayoutParams.WRAP_CONTENT,
////                ViewGroup.LayoutParams.WRAP_CONTENT
//                200.dpToPx(), // width in pixels
//                50.dpToPx(),  // height in pixels
//            ).apply {
//                gravity = Gravity.BOTTOM or Gravity.END
////                marginEnd = 32
////                bottomMargin = 32
//            }
//            elevation = 16f
//            setBackgroundColor(Color.WHITE)
//            background = GradientDrawable().apply {
//                shape = GradientDrawable.RECTANGLE
//                cornerRadius = 10.toPx(context).toFloat()
//                setColor(Color.WHITE) // background color
//            }
//        }

        // Add to root layout
        root.addView(fab2)


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