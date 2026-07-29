plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlinOptions {
    jvmTarget = "17"
}
    namespace = "com.bwnbits.bandwidthtester"

    compileSdk = 35

    defaultConfig {
        applicationId = "com.bwnbits.bandwidthtester"

        minSdk = 26
        targetSdk = 35

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}


dependencies {


    // Android Core
    implementation(
        "androidx.core:core-ktx:1.15.0"
    )


    // Activity Compose
    implementation(
        "androidx.activity:activity-compose:1.10.0"
    )


    // Material 3
    implementation(
        "androidx.compose.material3:material3:1.3.1"
    )


    // Compose UI
    implementation(
        "androidx.compose.ui:ui:1.7.6"
    )

    implementation(
        "androidx.compose.ui:ui-tooling-preview:1.7.6"
    )

    debugImplementation(
        "androidx.compose.ui:ui-tooling:1.7.6"
    )


    // ViewModel
    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7"
    )


    // Lifecycle
    implementation(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.8.7"
    )


    // Coroutines
    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0"
    )


    // OkHttp networking
    implementation(
        "com.squareup.okhttp3:okhttp:4.12.0"
    )


    // Foreground Service notification support
    implementation(
        "androidx.core:core-ktx:1.15.0"
    )


}
