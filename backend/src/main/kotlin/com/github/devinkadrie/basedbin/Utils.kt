package com.github.devinkadrie.basedbin

import io.ktor.http.*

fun RequestConnectionPoint.reconstruct() = "${scheme}://${serverHost}:${serverPort}${uri}"
