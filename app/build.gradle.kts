plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialization)
}

val appName = (rootProject.findProperty("app.name") as? String) ?: "DefaultApp"

android {
    namespace = "com.example.widgetgritty"

    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.widgetgritty"
        minSdk = 24
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
  implementation(platform(libs.androidx.compose.bom))
    // Core Android dependencies
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)


  // Arch Components
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Compose UI
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.compose.material3)

    // Android Activity integration
    implementation(libs.activity.compose)

    // Compose tooling (debug builds only)
  debugImplementation(libs.androidx.compose.ui.tooling)

  // Navigation
  implementation(libs.androidx.navigation3.ui)
  implementation(libs.androidx.navigation3.runtime)
  implementation(libs.androidx.lifecycle.viewmodel.navigation3)
implementation(libs.kotlinx.serialization.json)

}

// androidComponents {
//     onVariants { variant ->
//         variant.outputs.forEach { output ->
//             val safeAppName = appName.replace(Regex("[^A-Za-z0-9._-]"), "_")
//             val apkName = "${safeAppName}-${variant.buildType}-${output.versionName.get()}.apk"
//             (output as com.android.build.api.variant.impl.VariantOutputImpl).outputFileName.set(apkName)
//         }
//     }
// }
