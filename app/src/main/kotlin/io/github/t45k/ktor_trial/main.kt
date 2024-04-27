package io.github.t45k.ktor_trial

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.operations.Query
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") { call.respondText("Hello World!") }
        }
    }.start(wait = true)
}

class HelloWorldQuery : Query {
    fun hello(): String = "Hello World!"
}

fun Application.graphQLModule() {
    install(GraphQL) {
        schema {
            packages = listOf("io.github.t45k.ktor_trial")
            queries = listOf(
                HelloWorldQuery(),
            )
        }
    }
    install(Routing) {
        graphQLPostRoute()
    }
}
