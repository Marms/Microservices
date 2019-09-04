package fr.test.weightapi.web.feignClient;

import fr.weight.execisestemplateservice.controller.ControllerInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("exercice-template-svc")
public interface ExerciceTemplateSvc extends ControllerInterface {
}
