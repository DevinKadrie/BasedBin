package com.github.devinkadrie.basedbin.plugins

import com.github.devinkadrie.basedbin.*
import io.ktor.resources.Resource
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.resources.get
import io.ktor.server.resources.delete
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.routing
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import java.sql.Connection
import java.util.*

fun Application.configureRouting() {
    install(Resources)
    val dbConnection: Connection = connectToPostgres(embedded = false)
    val pasteService = PasteService(dbConnection)

    routing {
        get<Pastes.Id> { id ->
            call.respondText(pasteService.read(id.value).content)
        }

        post<Pastes> {
            val paste = call.receive<Paste>()

            val newId = pasteService.create(paste)

            val pasteUrl = "${call.request.local.reconstruct()}/$newId"

            call.respondText(pasteUrl)
        }

        // Make sure to check if it is actually a valid delete and make sure we know if the operation was successful
        delete<Pastes.Id> { id -> 
            try {
                pasteService.delete(id.value)
                call.respond(HttpStatusCode.OK)
            }
            catch (e: Exception) {
                call.respond(HttpStatusCode.NotFound, e.message ?: "Database error")
            }
        }
    }
}

@Resource("/pastes")
class Pastes {
    @Resource("{value}")
    class Id(
        val parent: Pastes = Pastes(),
        val value: @Serializable(with = UUIDSerializer::class) UUID
    )
}


