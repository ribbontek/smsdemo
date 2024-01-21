package com.ribbontek.smsdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmsDemoApplication

fun main(args: Array<String>) {
    runApplication<SmsDemoApplication>(*args)
}
