package fr.weight.serieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableJpaRepositories({"fr.weight.serieservice.dao"})
@EntityScan({"fr.weight.serieservice.dto"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@EnableDiscoveryClient // indique que nous somme un client eureka
public class SerieSvcMain {


    public static void main(String[] args) {
        SpringApplication.run(SerieSvcMain.class, args);
    }

}
