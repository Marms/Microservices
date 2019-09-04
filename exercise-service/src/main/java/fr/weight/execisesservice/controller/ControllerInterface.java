package fr.weight.execisesservice.controller;

import fr.weight.execisesservice.bo.Resource;
import fr.weight.execisesservice.dto.ExerciceModel;
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

    @Deprecated
    @RequestMapping("/exercices/all")
    HttpEntity<List<Resource>> all() throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/exercices/templates/{id}")
    HttpEntity<List<Resource>> allByTemplateId(@PathVariable(value="id")  Integer id) throws Exception;

    @Deprecated
    @RequestMapping(value = "/exercices/{id}")
    HttpEntity<Resource> one(@PathVariable(value="id") Integer id) throws Exception;

    @RequestMapping(value = "/exercices", method = RequestMethod.POST)
    HttpEntity<Resource> save(@RequestBody ExerciceModel m) throws Exception;

    /**
     * Recuperer les exercise de la seances
     * @param sceanceId le numéro de seance
     * @param exotemplateId le numéro d'exo
     * @return
     *      return la dernière version des exercises de la seance
     *       ou celui portant le exoTemplateID si renseignée
     * @throws Exception
     */
    @RequestMapping(value = "/seance/exercices")
    HttpEntity<List<Resource>> allBySeanceIdTemplateId(@PathParam(value="sceanceId")  Integer sceanceId,
                                                       @PathParam(value="exotemplateId") Integer exotemplateId) throws Exception;

    @RequestMapping(value = "/seance/exercices", method = RequestMethod.DELETE)
    HttpEntity<Resource> deleteExercise(@RequestBody ExerciceModel m) throws Exception;

}