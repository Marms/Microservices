package fr.weight.serieservice.controller;

import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dto.SerieModel;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Permet de partager le mapping entre le client et le serveur.
 */
public interface ControllerInterface {

    @RequestMapping("health")
    String health();

    @RequestMapping("/series/old")
    HttpEntity<List<Serie>> series() throws Exception;

    @RequestMapping("/series")
    HttpEntity<List<Serie>> seriesByScId(@RequestParam(value = "seanceId", required = true) Integer id,
                                         @RequestParam(value = "exoTemplateId") String value) throws Exception;

    @RequestMapping("/series/exercices/{id}")
    HttpEntity<List<Serie>> seriesFromExercise(@PathVariable(value = "id") Integer id) throws Exception;

    @RequestMapping(value = "/series/{id}")
    HttpEntity<Serie> serie(@PathVariable(value = "id") Integer id) throws Exception;

    @RequestMapping(value = "/series", method = RequestMethod.POST)
    HttpEntity<Serie> save(@RequestBody SerieModel m) throws Exception;

    @RequestMapping(value = "/series", method = RequestMethod.DELETE)
    HttpEntity<Serie> deleteSerie(@RequestBody SerieModel m,
                                  @RequestParam(value = "seanceId", required = true) Integer id,
                                  @RequestParam(value = "exoTemplateId") String exoTemplateId) throws Exception;


}