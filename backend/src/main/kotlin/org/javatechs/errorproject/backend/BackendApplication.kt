package org.javatechs.errorproject.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan

@SpringBootApplication
@EntityScan("org.javatechs.errorproject.backend.node")
class BackendApplication{

}

fun main(args: Array<String>) {
    SpringApplication.run(BackendApplication::class.java, *args)
}
