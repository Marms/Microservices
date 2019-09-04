package fr.weight.seancestemplateservice.controller;

import fr.weight.seancestemplateservice.bo.Ressource;
import fr.weight.seancestemplateservice.dto.SeanceModel;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Permet de partager le mapping entre le client et le serveur.
 */
public interface ControllerInterface {

    @RequestMapping("health")
    String health();

    @RequestMapping("/seances-templates")
    HttpEntity<List<Ressource>> all() throws Exception;

    @RequestMapping(value = "/seances-templates/{id}")
    HttpEntity<Ressource> one(@PathVariable(value="id") Integer id) throws Exception;

    @RequestMapping(value = "/seances-templates", method = RequestMethod.POST)
    HttpEntity<Ressource> save(@RequestBody SeanceModel m) throws Exception;
}