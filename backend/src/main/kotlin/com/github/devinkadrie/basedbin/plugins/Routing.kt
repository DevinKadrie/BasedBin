package com.github.devinkadrie.basedbin.plugins

import aws.sdk.kotlin.services.s3.S3Client
import aws.smithy.kotlin.runtime.net.url.Url
import com.github.devinkadrie.basedbin.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.resources.get
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import java.util.*

fun Application.configureRouting() {
    install(Resources)
    val client = S3Client {
        endpointUrl = Url.parse("http://localhost:4566")
        region = "us-east-1"
        forcePathStyle = true

    }
    val pasteService = PasteService(client)

    routing {
        get<Pastes.Id> { id ->
            call.respondOutputStream {
                try{
                    pasteService.read(id.id, this)
                }
                
                catch (e : StorageException){
                    call.respond(HttpStatusCode.NotFound, e.message ?: "Storage error")
                }
            }
        }

        post<Pastes> {
            val paste = call.receive<Paste>()
            val newId = pasteService.create(paste)
            if (newId == null) {
                call.respond(HttpStatusCode.InternalServerError, "Storage backend failure")
            }
            else {
                val pasteUrl = "${call.request.local.reconstruct()}/$newId"
                call.respondText(pasteUrl)
            }
        }
    }
}

@Resource("/pastes")
class Pastes {
    @Resource("{id}")
    class Id(
        val parent: Pastes = Pastes(),
        val id: @Serializable(with = UUIDSerializer::class) UUID
    )
}


