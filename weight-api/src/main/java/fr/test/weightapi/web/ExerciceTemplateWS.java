package fr.test.weightapi.web;

import fr.test.weightapi.bo.ExoPredef;
import fr.weight.execisestemplateservice.bo.Template;
import fr.test.weightapi.web.feignClient.ExerciceTemplateSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class ExerciceTemplateWS {

    //@Autowired
    private ExerciceTemplateSvc exoPredefService;

    @RequestMapping(value = "/v1/exopredef/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody  Collection<ExoPredef> get() throws Exception {
       /* HttpEntity<List<Template>> list = exoPredefService.all();
        list.getBody().stream();

        System.out.println("ExoPRedef get size " + list.size());*/
        return null;
    }

    @RequestMapping(value = "/v1/exopredef", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void post(@RequestBody ExoPredef exo) {
       /* ExoPredef save = exoPredefService.save(exo);
        System.out.println(save.getId());*/
    }


    @RequestMapping(value = "/v1/exopredef/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ExoPredef getSingle(@PathVariable("id") String id) {
       /* System.out.println("id = " + id);
        Optional<ExoPredef> exo = Optional.of(exoPredefService.find(id));
        if (exo.isPresent()) {
            System.out.println(exo.get().getName());
            return exo.get();
        } else {
            System.out.println("aucun exo ne possede cette id");
        }*/
        return null;

    }


}
