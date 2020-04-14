package fr.dawan.atelier;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyConfiguration {

    //Bean permettant de configurer l'application web
    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS");
            }

            //on peut configurer la partie web également
            @Override
            public void configureViewResolvers(ViewResolverRegistry registry) {
                registry.jsp("/WEB-INF/views/", ".jsp");
            }
        };
    }
}
