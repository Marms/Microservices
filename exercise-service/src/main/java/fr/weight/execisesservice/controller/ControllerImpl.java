package fr.weight.execisesservice.controller;

import com.netflix.discovery.EurekaClient;
import fr.weight.execisesservice.bo.Resource;
import fr.weight.execisesservice.dto.ExerciceModel;
import fr.weight.execisesservice.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private ExerciseService service;

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
    HttpEntity<List<Resource>> all() throws Exception {
        List<Resource> list = service.list().stream().map(
                model -> new Resource(model, linkToExercice(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Deprecated
    @Override
    public HttpEntity<Resource> one(Integer id) throws Exception {
        Resource s = new Resource(service.find(id));
        s.add(linkToExercice(s.getModel()));
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @Override
    public HttpEntity<List<Resource>> allByTemplateId(Integer m) throws Exception {
        List<Resource> list = service.listByTemplateId(m).stream().map(model -> new Resource(model, linkToExercice(model)))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Resource> save(ExerciceModel m) throws Exception {
        m.incremente();
        ExerciceModel model = service.save(m);
        Resource template = new Resource(model, linkToExercice(model));
        return new ResponseEntity<>(template, HttpStatus.OK);
    }

    @Override
    public HttpEntity<List<Resource>> allBySeanceIdTemplateId(Integer sceanceId, Integer exotemplateId) throws Exception {
        List<Resource> list = service.listBySeanceIdAndTemplateId(sceanceId, exotemplateId).stream().map(model -> new Resource(model, linkToExercice(model)))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Resource> deleteExercise(ExerciceModel m) throws Exception {
        m.delete();
        return this.save(m);
    }



    Link linkToExercice(ExerciceModel s) {
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
