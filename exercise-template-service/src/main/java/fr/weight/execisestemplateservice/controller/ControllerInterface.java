package fr.weight.execisestemplateservice.controller;

import fr.weight.execisestemplateservice.bo.Template;
import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;
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

    @RequestMapping("/exercices-templates")
    HttpEntity<List<Template>> all() throws Exception;

    @RequestMapping(value = "/exercices-templates/{id}")
    HttpEntity<Template> one(@PathVariable(value="id") Integer id) throws Exception;

    @RequestMapping(value = "/exercices-templates", method = RequestMethod.POST)
    HttpEntity<Template> save(@RequestBody ExerciceTemplateModel m) throws Exception;
}