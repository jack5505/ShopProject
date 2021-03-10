package uz.shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Configuration
@ComponentScan(basePackages = {"uz.shop.controllers"})
@EnableJpaRepositories(basePackages = {"uz.shop.repository"})
public class AppConfig {
}
