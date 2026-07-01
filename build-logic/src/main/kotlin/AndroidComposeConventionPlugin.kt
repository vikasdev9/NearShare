import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val androidExtension = extensions.getByType<BaseExtension>()

            androidExtension.apply {
                buildFeatures.compose = true
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.10"
                }
            }
        }
    }
}
