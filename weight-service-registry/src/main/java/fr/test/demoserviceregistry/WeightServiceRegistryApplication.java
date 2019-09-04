package fr.test.demoserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeightServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightServiceRegistryApplication.class, args);
    }

}
