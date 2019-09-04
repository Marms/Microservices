package fr.weight.seancestemplateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableJpaRepositories({"fr.weight.seancestemplateservice.dao"})
@EntityScan({"fr.weight.seancestemplateservice.dto"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class SeanceTemplateServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(SeanceTemplateServiceApplication.class, args);
    }

}
