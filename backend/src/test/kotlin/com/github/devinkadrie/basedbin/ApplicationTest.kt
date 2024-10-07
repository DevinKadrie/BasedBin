package com.github.devinkadrie.basedbin

import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import java.util.*
import kotlin.test.*
import org.junit.jupiter.api.assertDoesNotThrow

class ApplicationTest {
    @Test
    fun testPasteRoutes() = testApplication {
        val pasteService = MockPasteService()
        application { installPlugins() }
        routing { pasteRoutes(pasteService) }

        val client = createClient { install(ContentNegotiation) { json() } }
        val paste = Paste("This is just a cute lil' guy")

        val id =
            client
                .post("/pastes") {
                    contentType(ContentType.Application.Json)
                    setBody(paste)
                }
                .let {
                    assertEquals(HttpStatusCode.Created, it.status)
                    it.bodyAsText().also { assertDoesNotThrow { UUID.fromString(it) } }
                }

        client.get("/pastes/$id").let {
            assertEquals(HttpStatusCode.OK, it.status)
            assertEquals(paste.content, it.body<Paste>().content)
        }
    }
}
