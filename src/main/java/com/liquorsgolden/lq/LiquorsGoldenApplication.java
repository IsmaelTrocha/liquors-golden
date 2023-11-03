package com.liquorsgolden.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
public class LiquorsGoldenApplication {

  public static void main(String[] args) {
    SpringApplication.run(LiquorsGoldenApplication.class, args);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("https://liquors-golden-production.up.railway.app/**") // Reemplaza con tu origen permitido
            .allowedMethods("GET", "POST", "PUT", "DELETE"); // Especifica los métodos permitidos
      }
    };
  }

}
