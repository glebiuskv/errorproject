package org.javatechs.errorproject.backend.annotation

import org.springframework.web.bind.annotation.RestController

@Target(AnnotationTarget.CLASS,AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@RestController

annotation class RestApiController