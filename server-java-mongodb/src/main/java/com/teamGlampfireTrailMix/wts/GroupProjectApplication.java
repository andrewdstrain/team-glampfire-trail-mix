package com.teamGlampfireTrailMix.wts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.teamGlampfireTrailMix.wts.*")
public class GroupProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:3000","http://localhost:4200","http://localhost:8081");
                registry.addMapping("/**").allowedMethods("*"); // Allow everything - for testing
            }
        };
    }

}
