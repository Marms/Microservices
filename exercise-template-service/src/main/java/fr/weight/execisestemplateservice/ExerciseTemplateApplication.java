package fr.weight.execisestemplateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableJpaRepositories({"fr.weight.execisestemplateservice.dao"})
@EntityScan({"fr.weight.execisestemplateservice.dto"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class ExerciseTemplateApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExerciseTemplateApplication.class, args);
    }

}
