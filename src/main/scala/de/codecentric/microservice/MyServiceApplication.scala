package de.codecentric.microservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{Banner, SpringApplication, WebApplicationType}
import org.springframework.boot.autoconfigure. SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableScheduling

object MyServiceApplication {
  def main(args: Array[String]) : Unit = SpringApplication.run(classOf[MyServiceApplication], args :_ *)
}

@SpringBootApplication
class MyServiceApplication {}
