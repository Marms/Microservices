package fr.weight.seancesservice.controller;

import fr.weight.seancesservice.bo.Ressource;
import fr.weight.seancesservice.dto.SeanceModel;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Permet de partager le mapping entre le client et le serveur.
 */
public interface ControllerInterface {

    @RequestMapping("health")
    String health();

    /**
     * Retourne la dernière version de chaque seances
     * @return
     * @throws Exception
     */
    @RequestMapping("/seances")
    HttpEntity<List<Ressource>> all() throws Exception;

    @RequestMapping(value = "/seances/{id}")
    HttpEntity<Ressource> one(@PathVariable(value="id") Integer id) throws Exception;

    @RequestMapping(value = "/seances", method = RequestMethod.POST)
    HttpEntity<Ressource> save(@RequestBody SeanceModel m) throws Exception;

    @Deprecated
    @RequestMapping(value = "/seances/template")
    HttpEntity<List<Ressource>> allBySeanceTemplate(@PathParam(value="templateId") Integer templateId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/seances")
    HttpEntity<Ressource> delete(@RequestBody SeanceModel m) throws Exception;
}