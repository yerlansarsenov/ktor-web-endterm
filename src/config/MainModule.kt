package com.webendterm.config

import com.webendterm.controller.TodoRoutes
import com.webendterm.dao.TodoRepository
import com.webendterm.mapper.TodoMapper
import com.webendterm.service.TodoService
import com.google.inject.AbstractModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import java.text.DateFormat

class MainModule constructor(
    private val application: Application
) : AbstractModule() {

    override fun configure() {
        application.install(ContentNegotiation) {
            gson {
                setDateFormat(DateFormat.LONG)
                setPrettyPrinting()
            }
        }
        application.install(DefaultHeaders)

        bind(Application::class.java).toInstance(application)
        bind(TodoRoutes::class.java).asEagerSingleton()
        bind(TodoMapper::class.java).asEagerSingleton()
        bind(TodoRepository::class.java).asEagerSingleton()
        bind(TodoService::class.java).asEagerSingleton()
    }
}
