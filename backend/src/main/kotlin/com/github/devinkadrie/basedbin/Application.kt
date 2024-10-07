package com.github.devinkadrie.basedbin

import aws.sdk.kotlin.services.s3.S3Client
import aws.smithy.kotlin.runtime.net.url.Url
import io.ktor.server.application.*
import java.sql.Connection

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.basedbin() {
    installPlugins()

    val client = S3Client {
        endpointUrl = Url.parse("http://localhost:4566")
        region = "us-east-1"
        forcePathStyle = true
    }
    val pasteService = S3PasteService(client)
    val dbConnection: Connection = connectToPostgres(embedded = false)
    val userService = DefaultUserService(dbConnection)

    configureRouting(pasteService, userService)
}
