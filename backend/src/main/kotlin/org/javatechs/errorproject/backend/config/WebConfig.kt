package org.javatechs.errorproject.backend.config

import org.javatechs.errorproject.backend.annotation.RestApiController
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method


@Configuration
class WebConfig : WebMvcConfigurer, WebMvcRegistrations {
    private val API_BASE_PATH = "/api"

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry!!.addResourceHandler("/frontend/**")
                .addResourceLocations("classpath:/app/")
    }

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        registry!!.addRedirectViewController("/", "/frontend/index.html")
        registry.addRedirectViewController("/frontend/", "/frontend/index.html")
    }

    override fun getRequestMappingHandlerMapping(): RequestMappingHandlerMapping {
        return object : RequestMappingHandlerMapping() {
            override fun registerHandlerMethod(handler: Any, method: Method, mapping: RequestMappingInfo) {
                @Suppress("NAME_SHADOWING")
                var mapping = mapping
                val beanType = method.declaringClass
                val restApiController = beanType.getAnnotation(RestApiController::class.java)
                if (restApiController != null) {
                    val apiPattern = PatternsRequestCondition(API_BASE_PATH)
                            .combine(mapping.patternsCondition)

                    mapping = RequestMappingInfo(mapping.name, apiPattern,
                            mapping.methodsCondition, mapping.paramsCondition,
                            mapping.headersCondition, mapping.consumesCondition,
                            mapping.producesCondition, mapping.customCondition)
                }

                super.registerHandlerMethod(handler, method, mapping)
            }
        }
    }
}