pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "QuickDrop"

include(":app")
include(":desktopApp")

include(":core:common")
include(":core:domain")
include(":core:model")
include(":core:designsystem")
include(":core:network")
include(":core:network-desktop")
include(":core:database")
include(":core:database-desktop")
include(":core:ui")

include(":feature:home")
include(":feature:discovery")
include(":feature:transfer")
include(":feature:filepicker")
include(":feature:history")
include(":feature:settings")
