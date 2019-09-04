package fr.weight.execisesservice.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.weight.execisesservice.dto.ExerciceModel;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class Resource extends ResourceSupport {

    private ExerciceModel model;

    @JsonCreator
    public Resource(@JsonProperty("content") ExerciceModel model) {
        this.model = model;
    }


    public Resource(@JsonProperty("content") ExerciceModel model, Link l) {
        this.model = model;
        this.add(l);
    }

}
