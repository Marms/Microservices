package fr.weight.serieservice.controller;

import com.netflix.discovery.EurekaClient;
import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dto.SerieModel;
import fr.weight.serieservice.service.SerieService;
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
public class SerieServiceApplication implements ControllerInterface {

    @Autowired
    @Lazy
    private EurekaClient client;

    @Autowired
    private SerieService service;

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
    public HttpEntity<List<Serie>> seriesByScId(Integer id, String value) throws Exception {
        List<Serie> list = service.listFromSeanceIdExoTemplateId(id, value).stream().map(
                model -> new Serie(model, linkToSerie(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public @ResponseBody
    HttpEntity<List<Serie>> series() throws Exception {
        List<Serie> list = service.list().stream().map(
                model -> new Serie(model, linkToSerie(model)))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Serie> serie(Integer id) throws Exception {
        Serie s = new Serie(service.find(id));
        s.add(linkToSerie(s.getModel()));
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    Link linkToSerie(SerieModel s) {
        try {
            Link l = linkTo(
                    methodOn(SerieServiceApplication.class)
                            .serie(s.getId())
            ).withSelfRel();
            return l;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public HttpEntity<List<Serie>> seriesFromExercise(Integer id) throws Exception {
        List<SerieModel> list = service.listFromExoId(id);
        List<Serie> series = list.stream().map(serieModel -> new Serie(serieModel, linkToSerie(serieModel))).collect(Collectors.toList());
        return new ResponseEntity<>(series, HttpStatus.OK);
    }

    @Override
    public HttpEntity<Serie> deleteSerie(SerieModel m, Integer id, String exoTemplateId) throws Exception {
        m.incrementeVersion();
        m.delete();
        service.save(m);
        Serie serie = new Serie(m, linkToSerie(m));
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    // Si version = null creation
    // sinon update ? pas de PUT ?
    @Override
    public HttpEntity<Serie> save(SerieModel m) throws Exception {
        m.incrementeVersion();
        SerieModel model = service.save(m);
        Serie serie = new Serie(model, linkToSerie(model));
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

}
