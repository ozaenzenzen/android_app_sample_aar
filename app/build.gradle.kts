import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.appsample2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appsample2"
        minSdk = 24
        targetSdk = 35
        versionCode = 6
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
            applicationVariants.all {
                outputs.all { output ->
                    if (output is BaseVariantOutputImpl) {
                        val project = "App Sample Android Konnek"
                        val separator = "_"
                        val buildType = buildType.name
                        val version = versionName
                        val formattedDate = SimpleDateFormat("MM-dd-yyyy_hh-mm").format(Date())
                        val filename =
                            "$project$version$separator$buildType$separator$formattedDate.apk"
                        output.outputFileName = filename
                    }
                    true
                }
            }
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.konneknative:konnek-android:1.0.0")
    implementation("com.github.ozaenzenzen:librarysample1:1.0.4")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}