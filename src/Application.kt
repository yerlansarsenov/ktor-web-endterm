package com.webendterm

import com.webendterm.config.MainModule
import com.google.inject.Guice
import io.ktor.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    Guice.createInjector(MainModule(this))
}
