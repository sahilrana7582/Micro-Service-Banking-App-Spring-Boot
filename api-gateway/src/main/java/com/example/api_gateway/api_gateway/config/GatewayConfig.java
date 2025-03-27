package com.example.api_gateway.api_gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocater(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/api/account/**")
                        .uri("http://localhost:8081"))
                .route("card-service", r -> r.path("/api/card/**")
                        .uri("lb://card-service"))
                .build();
    }
}
