package fr.weight.seancestemplateservice.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.weight.seancestemplateservice.dto.SeanceModel;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class Ressource extends ResourceSupport {

    private SeanceModel model;

    @JsonCreator
    public Ressource(@JsonProperty("content") SeanceModel model) {
        this.model = model;
    }


    public Ressource(@JsonProperty("content") SeanceModel model, Link l) {
        this.model = model;
        this.add(l);
    }

}
