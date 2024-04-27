package io.github.t45k.ktor_trial

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.operations.Query
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.Routing

fun main() {
    embeddedServer(Netty, 8080) {
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
    }.start(wait = true)
}

class HelloWorldQuery : Query {
    fun hello(): String = "Hello World!"
}
