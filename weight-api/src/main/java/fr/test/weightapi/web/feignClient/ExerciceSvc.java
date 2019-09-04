package fr.test.weightapi.web.feignClient;

import fr.weight.execisesservice.controller.ControllerInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("exercice-svc")
public interface ExerciceSvc extends ControllerInterface {
}
