package com.br.agrotechapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
               .info(new Info()
                  .title("API do AgroTech")
                  .version("V1")
                  .description("API para controler das informações do AgroTech")
                  .contact(new Contact().name("Vinícius Yoda").email("vyoda@fiap.com.br"))
               )
               .components(new Components()
                        .addSecuritySchemes("bearer-key", 
                                 new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                 .bearerFormat("JWT")));
   }
   
}