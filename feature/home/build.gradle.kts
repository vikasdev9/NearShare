plugins {
    id("quickdrop.android.library")
    id("quickdrop.android.compose")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.quickdrop.feature.home"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
