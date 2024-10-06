rootProject.name = "com.github.devinkadrie.basedbin"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.8.0")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "2.0.20")
            val ktor = version("ktor", "3.0.0-rc-2")

            plugin(
                "ktfmt",
                "com.ncorti.ktfmt.gradle"
            ).version("0.20.1")

            plugin(
                "kotlin-jvm",
                "org.jetbrains.kotlin.jvm"
            ).versionRef(kotlin)

            plugin(
                "kotlinx-serialization",
                "org.jetbrains.kotlin.plugin.serialization"
            ).versionRef(kotlin)

            plugin(
                "ktor",
                "io.ktor.plugin"
            ).versionRef(ktor)

            library(
                "ktor-server",
                "io.ktor",
                "ktor-server-core-jvm"
            ).versionRef(ktor)

            library(
                "ktor-server-resources",
                "io.ktor",
                "ktor-server-resources-jvm"
            ).versionRef(ktor)

            library(
                "ktor-server-cors",
                "io.ktor",
                "ktor-server-cors-jvm"
            ).versionRef(ktor)

            library(
                "ktor-server-netty",
                "io.ktor",
                "ktor-server-netty-jvm"
            ).versionRef(ktor)

            library(
                "ktor-server-config",
                "io.ktor",
                "ktor-server-config-yaml"
            ).versionRef(ktor)

            bundle(
                "ktor.core",
                listOf(
                    "ktor-server",
                    "ktor-server-resources",
                    "ktor-server-cors",
                    "ktor-server-netty",
                    "ktor-server-config",
                )
            )

            library(
                "ktor-json",
                "io.ktor",
                "ktor-serialization-kotlinx-json-jvm"
            ).versionRef(ktor)

            library(
                "ktor-server-content-negotiation",
                "io.ktor",
                "ktor-server-content-negotiation-jvm"
            ).versionRef(ktor)

            bundle(
                "ktor-plugins",
                listOf(
                    "ktor-json",
                    "ktor-server-content-negotiation"
                )
            )

            library(
                "ktor-test-host",
                "io.ktor",
                "ktor-server-test-host-jvm"
            ).versionRef(ktor)

            library(
                "ktor-client-content-negotiation",
                "io.ktor",
                "ktor-client-content-negotiation-jvm"
            ).versionRef(ktor)

            bundle(
                "ktor-test",
                listOf(
                    "ktor-test-host",
                    "ktor-client-content-negotiation"
                )
            )

            library(
                "h2",
                "com.h2database:h2:2.1.214"
            )

            library(
                "uuid",
                "com.fasterxml.uuid:java-uuid-generator:5.1.0",
            )

            library(
                "s3",
                "aws.sdk.kotlin:s3:1.3.23"
            )

            library(
                "postgres",
                "org.postgresql:postgresql:42.7.2"
            )

            library(
                "logback",
                "ch.qos.logback:logback-classic:1.4.14"
            )

            library(
                "kotlin-test",
                "org.jetbrains.kotlin:kotlin-test-junit:2.0.10"
            )
        }
    }
}
