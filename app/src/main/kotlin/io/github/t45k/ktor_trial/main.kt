package io.github.t45k.ktor_trial

import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") { call.respondText("Hello World!") }
        }
    }.start(wait = true)
}
