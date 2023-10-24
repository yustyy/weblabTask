package com.example.weblabTask.api.configs;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

public class SwaggerConfigs {

	
	@Bean
	 public OpenAPI openApiInformation() {
	  Server localServer = new Server()
	                      .url("http://localhost:8080")
	                      .description("Task falan filan");

	  Contact contact = new Contact()
	                    .email("yusuf.acmaci@hotmail.com")
	                    .name("Yusuf Açmacı");

	  Info info = new Info()
	              .contact(contact)
	              .description("Spring Boot 3 + Open API 3")
	              .summary("AL SANA API")
	              .title("APIMSI")
	              .version("V1.0.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org"));

	  return new OpenAPI().info(info).addServersItem(localServer);
	 }
	
	
}
