package org.javatechs.errorproject.backend.controller

import org.javatechs.errorproject.backend.annotation.RestApiController
import org.springframework.web.bind.annotation.GetMapping

/**
 * Sample example REST controller
 */
@RestApiController
class ExampleDataController {

    @GetMapping("/test")
    fun redirect(): Any {
        return hashMapOf(1 to "x", 2 to "y", -1 to "zz")
    }
}