package org.javatechs.errorproject.backend.controller.helper

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.View
import org.springframework.web.servlet.view.InternalResourceView


@Controller
@RequestMapping("/frontend")
class FrontendController {
    /**
     * Smart-ass trick to handle angular routing
     */
    @GetMapping(value = "/{path:[^\\.]*}")
    fun redirect(): View {
        // Forward to home page so that route is preserved.
        return InternalResourceView("/frontend/index.html")
    }
}