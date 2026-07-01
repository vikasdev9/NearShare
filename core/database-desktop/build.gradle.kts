plugins {
    id("quickdrop.kotlin.library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.sqlite.bundled)
}

room {
    schemaDirectory("$projectDir/schemas")
}
