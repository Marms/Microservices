package fr.weight.seancesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableJpaRepositories({"fr.weight.seancesservice.dao"})
@EntityScan({"fr.weight.seancesservice.dto"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@EnableDiscoveryClient // indique que nous somme un client eureka
public class SeanceServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(SeanceServiceApplication.class, args);
    }

}
