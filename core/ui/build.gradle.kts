plugins {
    id("quickdrop.android.library")
    id("quickdrop.android.compose")
}

android {
    namespace = "com.example.quickdrop.core.ui"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
}
