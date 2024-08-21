package com.github.devinkadrie.basedbin.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import java.util.UUID
import kotlinx.serialization.Serializable

@Serializable
data class Paste(val content: String)

fun Application.configureRouting() {
    install(Resources)
    routing {
        get("/") {
            call.respondText("Hi Shane")
        }
        get("/{id}") {
            val contents = File(call.parameters["id"]!!).readText()
            call.respondText(contents)
        }
        post("/") {
            val paste = call.receive<Paste>()
            val id = UUID.randomUUID().toString()
            File(id).writeText(paste.content)
            call.respondText(id)
        }
    }
}



