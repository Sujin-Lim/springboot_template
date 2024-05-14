package org.example.springboot_test;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("join.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        log.debug("::::::: addViewControllers: index.html");
    }

    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        String version = org.springframework.core.SpringVersion.getVersion();
        log.debug("::::::: Spring Version: " + version);
    }

}
