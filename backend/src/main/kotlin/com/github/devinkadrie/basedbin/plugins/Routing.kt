package com.github.devinkadrie.basedbin.plugins

import com.github.devinkadrie.basedbin.Paste
import com.github.devinkadrie.basedbin.PasteService
import com.github.devinkadrie.basedbin.connectToPostgres
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.sql.Connection

fun Application.configureRouting() {
    install(Resources)
    val dbConnection: Connection = connectToPostgres(embedded = false)
    val pasteService = PasteService(dbConnection)

    routing {
        get("/") {
            call.respondText("Hi Shane")
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()!!
            call.respondText(pasteService.read(id).content)
        }

        post("/") {
            val paste = call.receive<Paste>()
            call.respondText(pasteService.create(paste).toString())
        }
    }
}



