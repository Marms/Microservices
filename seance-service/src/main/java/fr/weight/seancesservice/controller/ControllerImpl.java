package fr.weight.seancesservice.controller;

import com.netflix.discovery.EurekaClient;
import fr.weight.seancesservice.bo.Ressource;
import fr.weight.seancesservice.dto.SeanceModel;
import fr.weight.seancesservice.service.SeanceService;
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

//TODO
@RestController
public class ControllerImpl implements ControllerInterface {

    @Autowired
    @Lazy
    private EurekaClient client;

    @Autowired
    private SeanceService service;

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
    HttpEntity<List<Ressource>> all() throws Exception {
        List<Ressource> list = service.lastVersionOfAllSeances().stream().map(
                model -> new Ressource(model, linkToSeance(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Ressource> one(Integer id) throws Exception {
        Ressource s = new Ressource(service.find(id));
        s.add(linkToSeance(s.getModel()));
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @Override
    public HttpEntity<List<Ressource>> allBySeanceTemplate(Integer templateId) {
        List<Ressource> list = service.listByTemplateId(templateId).stream()
                .map(model -> new Ressource(model, linkToSeance(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Ressource> save(SeanceModel m) throws Exception {
        m.increment();
        SeanceModel model = service.save(m);
        Ressource template = new Ressource(model, linkToSeance(model));
        return new ResponseEntity<>(template, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Ressource> delete(SeanceModel m) throws Exception {
        m.delete();
        return this.save(m);
    }

    Link linkToSeance(SeanceModel s) {
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

    //TODO voir comment gerer le fait que l'on est plusieur micro service (pointer vers le zuul // vip ) ?
    Link linkToExerciceTemplate(SeanceModel model) {
        Link l = null; //new Link(); // lien vers la vip
        return l;
    }

    //TODO voir comment gerer le fait que l'on est plusieur micro service (pointer vers le zuul // vip ) ?
    Link linkToSerie(SeanceModel model) {
        Link l = null; //new Link(); // lien vers la vip
        return l;
    }

}
