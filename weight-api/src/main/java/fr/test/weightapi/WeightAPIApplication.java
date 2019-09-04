package fr.test.weightapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"fr.test.weightapi.web.feignClient", "fr.test.weightapi.web"})
@EnableDiscoveryClient // indique que nous somme un client eureka
@EnableZuulProxy// indique que nous somme un serveur zuul
//@EnableFeignClient
public class WeightAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightAPIApplication.class, args);
    }
}