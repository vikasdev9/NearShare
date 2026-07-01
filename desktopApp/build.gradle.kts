import org.gradle.kotlin.dsl.dependencies

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    implementation(project(":core:network-desktop"))
    implementation(project(":core:database-desktop"))

    implementation(compose.desktop.currentOs)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}

compose.desktop {
    application {
        mainClass = "com.example.quickdrop.MainKt"
        nativeDistributions {
            targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi)
            packageName = "QuickDrop"
            packageVersion = "1.0.0"
            vendor = "QuickDrop Authors"
            copyright = "Copyright 2024"
            
            windows {
                iconFile.set(project.file("src/jvmMain/resources/app_icon.ico"))
                menu = true
                shortcut = true
            }
        }
    }
}
