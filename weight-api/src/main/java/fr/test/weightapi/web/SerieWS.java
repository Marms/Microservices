package fr.test.weightapi.web;

import fr.test.weightapi.web.feignClient.SerieSvc;
import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dto.SerieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieWS {

   // @Autowired
    private SerieSvc serieSvc;
    
   /** @RequestMapping(method = RequestMethod.GET,
            value= "/v1/seance/{seanceId}/exercice/{exerciceId}/serie/list",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Collection<SerieModel> get(@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId) throws Exception {
        HttpEntity<List<Serie>> list =  serieSvc.seriesFromExercise(exId);
        return list.getBody().stream().map(s -> s.getModel()).collect(Collectors.toList());
    }
 */
    /** Ajoute une serie a l'exercice
     *
     * @throws Exception **/
    /**
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie",
            method= RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody SerieModel addSerieToExercice (@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @RequestBody SerieModel serie) throws Exception {
        // recuperation de l'exercice
        HttpEntity<Serie> s = serieSvc.save(serie);
        return s.getBody().getModel();
    }
 */
    /**
     * Update une serie
     * @param scId seanceID non utilise
     * @param exId exerciceID
     * @param serie la serie a modifier
     * @return
     * @throws Exception

    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie/{serieId}",
            method= RequestMethod.PATCH, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody void updateSerie (@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @PathVariable("serieId") Integer serieId, @RequestBody String serie) throws Exception {

    }
     */
    /**
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie/{numero}",
            method= RequestMethod.DELETE)
    public @ResponseBody void deleteSerie(@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @PathVariable("numero") Integer numero) throws Exception {

    } */

}
