package fr.test.weightapi.web.feignClient;

import fr.weight.seancesservice.controller.ControllerInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("seance-svc")
public interface SeanceSvc extends ControllerInterface {
}
