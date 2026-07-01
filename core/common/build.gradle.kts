plugins {
    id("quickdrop.kotlin.library")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(libs.javax.inject)
    implementation(libs.hilt.core)
    implementation(libs.dagger)
    ksp(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
}
