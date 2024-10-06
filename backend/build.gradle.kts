plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ktor)
}

group = "com.github.devinkadrie.basedbin"
version = "0.1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
        vendor = JvmVendorSpec.AMAZON
    }
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktor.core)
    implementation(libs.bundles.ktor.plugins)

    implementation(libs.uuid)
    implementation(libs.h2)
    implementation(libs.s3)
    implementation(libs.postgres)
    implementation(libs.logback)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.bundles.ktor.test)
}
