package com.github.devinkadrie.basedbin

import com.github.devinkadrie.basedbin.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureRouting()
}
