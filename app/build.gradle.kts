plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

val appName = (rootProject.findProperty("app.name") as? String) ?: "DefaultApp"

android {
    namespace = "com.example.widgeritty"
    compileSdk = 37

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

androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            val safeAppName = appName.replace(Regex("[^A-Za-z0-9._-]"), "_")
            val apkName = "${safeAppName}-${variant.buildType}-${output.versionName.get()}.apk"
            (output as com.android.build.api.variant.impl.VariantOutputImpl).outputFileName.set(apkName)
        }
    }
}
