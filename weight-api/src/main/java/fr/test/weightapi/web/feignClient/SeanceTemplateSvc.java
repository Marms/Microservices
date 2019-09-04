package fr.test.weightapi.web.feignClient;

import fr.weight.seancestemplateservice.controller.ControllerInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("seance-template-svc")
public interface SeanceTemplateSvc extends ControllerInterface {
}
