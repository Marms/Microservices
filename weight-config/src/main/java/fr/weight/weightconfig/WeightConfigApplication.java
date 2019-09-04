package fr.weight.weightconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class WeightConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightConfigApplication.class, args);
    }
}
