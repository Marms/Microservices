package fr.weight.execisesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableJpaRepositories({"fr.weight.execisesservice.dao"})
@EntityScan({"fr.weight.execisesservice.dto"})
@EnableDiscoveryClient // indique que nous somme un client eureka
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class ExerciseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseServiceApplication.class, args);
    }

}
