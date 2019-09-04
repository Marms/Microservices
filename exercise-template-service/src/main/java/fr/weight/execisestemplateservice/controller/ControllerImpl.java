package fr.weight.execisestemplateservice.controller;

import com.netflix.discovery.EurekaClient;
import fr.weight.execisestemplateservice.bo.Template;
import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;
import fr.weight.execisestemplateservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ControllerImpl implements ControllerInterface {

    @Autowired
    @Lazy
    private EurekaClient client;

    @Autowired
    private TemplateService service;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    @Override
    public String health() {
        System.out.println("" + client.getApplicationInfoManager().getEurekaInstanceConfig().getSecurePort());
        return String.format("Hello from '%s' on '%s'!", client.getApplication(appName).getName(), portNumber);
    }

    @Override
    public @ResponseBody
    HttpEntity<List<Template>> all() throws Exception {
        List<Template> list = service.list().stream().map(
                model -> new Template(model, linkToSerie(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Template> one(Integer id) throws Exception {
        Template s = new Template(service.find(id));
        s.add(linkToSerie(s.getModel()));
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Template> save(ExerciceTemplateModel m) throws Exception {
        ExerciceTemplateModel model = service.save(m);
        System.out.println(model.getId());
        Template template = new Template(model, linkToSerie(model));
        return new ResponseEntity<>(template, HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(ControllerImpl.class, args);
    }


    Link linkToSerie(ExerciceTemplateModel s) {
        try {
            Link l = linkTo(
                    methodOn(ControllerImpl.class)
                            .one(s.getId())
            ).withSelfRel();
            return l;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
