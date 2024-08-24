package com.github.devinkadrie.basedbin.plugins

import com.github.devinkadrie.basedbin.*
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.resources.get
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import java.sql.Connection
import java.util.*

fun Application.configureRouting() {
    install(Resources)
    val dbConnection: Connection = connectToPostgres(embedded = false)
    val pasteService = PasteService(dbConnection)

    routing {
        get("/healthcheck") {
            call.respond(HttpStatusCode.OK, "OK")
        }

        get<Pastes.Id> { id ->
            call.respondText(pasteService.read(id.id).content)
        }

        post<Pastes> {
            val paste = call.receive<Paste>()

            val newId = pasteService.create(paste)

            val pasteUrl = "${call.request.local.reconstruct()}/$newId"

            call.respondText(pasteUrl, status = HttpStatusCode.Created)
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


