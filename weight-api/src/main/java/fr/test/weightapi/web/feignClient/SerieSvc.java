package fr.test.weightapi.web.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import fr.weight.serieservice.controller.ControllerInterface;

@FeignClient("serie-svc")
public interface SerieSvc extends ControllerInterface{


}
