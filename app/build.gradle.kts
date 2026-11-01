plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.widgeritty"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.widgeritty"
        minSdk = 23
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Compose version management
    implementation(platform(libs.compose.bom))

    // Compose UI
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.material3)

    // Android Activity integration
    implementation(libs.activity.compose)

    // Compose tooling (debug builds only)
    debugImplementation(libs.compose.ui.tooling)
}
