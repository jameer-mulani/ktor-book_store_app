package com.learningktor.plugins

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import io.ktor.serialization.gson.*
import io.ktor.serialization.jackson.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import java.lang.reflect.Type
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        /*gson {
            setPrettyPrinting()
            registerTypeAdapter(LocalDateTime::class.java, object : JsonDeserializer<LocalDateTime>{
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): LocalDateTime {
                    val instant = Instant.ofEpochMilli(json!!.asJsonPrimitive.asLong)
                    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                }

            })
        }*/


        jackson {
            registerModule(JavaTimeModule())
        }

    }

    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}
