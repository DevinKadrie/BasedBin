package com.github.devinkadrie.basedbin

import io.ktor.http.HttpStatusCode
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.get
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*
import kotlinx.serialization.Serializable

fun Route.pasteRoutes(pasteService: PasteService) {
    get<Pastes.Id> { call.respond(pasteService.read(it.id) ?: HttpStatusCode.NotFound) }

    post<Pastes> {
        val paste = call.receive<Paste>()
        val id = pasteService.create(paste)
        if (id == null) {
            call.respond(HttpStatusCode.InternalServerError, "Storage backend failure")
        } else {
            call.respondText(id.toString(), status = HttpStatusCode.Created)
        }
    }
}

fun Route.userRoutes(userService: UserService){
    post("/register"){
        val user = call.receive<User>()
        try {
            userService.create(user)
            call.respond(HttpStatusCode.Created)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
    post("/login") {
        val user = call.receive<User>()
        if (userService.exists(user)) {
            call.respond(HttpStatusCode.OK)
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}
fun Application.configureRouting(pasteService: PasteService, userService: UserService) {
    routing {
        pasteRoutes(pasteService)
        userRoutes(userService)
    }
}

@Resource("/pastes")
class Pastes {
    @Resource("{id}")
    class Id(
        val parent: Pastes = Pastes(),
        val id: @Serializable(with = UUIDSerializer::class) UUID,
    )
}
