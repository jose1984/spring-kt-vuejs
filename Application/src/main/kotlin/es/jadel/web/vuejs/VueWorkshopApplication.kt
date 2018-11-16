package es.jadel.web.vuejs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class VueWorkshopApplication : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder =
            application.sources(VueWorkshopApplication::class.java)

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<VueWorkshopApplication>(*args)
        }
    }

}